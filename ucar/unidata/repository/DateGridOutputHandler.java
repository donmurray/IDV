/**
 *
 * Copyright 1997-2005 Unidata Program Center/University Corporation for
 * Atmospheric Research, P.O. Box 3000, Boulder, CO 80307,
 * support@unidata.ucar.edu.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or (at
 * your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package ucar.unidata.repository;


import org.w3c.dom.*;


import ucar.unidata.sql.SqlUtil;
import ucar.unidata.ui.ImageUtils;
import ucar.unidata.util.DateUtil;
import ucar.unidata.util.HtmlUtil;
import ucar.unidata.util.IOUtil;
import ucar.unidata.util.Misc;

import ucar.unidata.util.StringBufferCollection;
import ucar.unidata.util.StringUtil;
import ucar.unidata.util.TwoFacedObject;
import ucar.unidata.xml.XmlUtil;

import java.io.*;

import java.io.File;
import java.io.InputStream;



import java.net.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;


import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;



import java.util.regex.*;

import java.util.zip.*;


/**
 * Class SqlUtil _more_
 *
 *
 * @author IDV Development Team
 * @version $Revision: 1.3 $
 */
public class DateGridOutputHandler extends OutputHandler {



    /** _more_ */
    public static final String OUTPUT_GRID = "calendar.grid";

    /** _more_          */
    public static final String OUTPUT_CALENDAR = "calendar.calendar";


    /**
     * _more_
     *
     * @param repository _more_
     * @param element _more_
     * @throws Exception _more_
     */
    public DateGridOutputHandler(Repository repository, Element element)
            throws Exception {
        super(repository, element);
    }

    /**
     * _more_
     *
     *
     * @param output _more_
     *
     * @return _more_
     */
    public boolean canHandle(String output) {
        return output.equals(OUTPUT_GRID) || output.equals(OUTPUT_CALENDAR);
    }



    /**
     * _more_
     *
     * @param request _more_
     * @param entries _more_
     * @param types _more_
     *
     *
     * @throws Exception _more_
     */
    protected void getOutputTypesForEntries(Request request,
                                            List<Entry> entries,
                                            List<OutputType> types)
            throws Exception {
        types.add(new OutputType("Calendar", OUTPUT_CALENDAR));
        types.add(new OutputType("Date Grid", OUTPUT_GRID));
    }



    /**
     * _more_
     *
     * @param request _more_
     * @param entry _more_
     * @param types _more_
     *
     * @throws Exception _more_
     */
    protected void getOutputTypesForEntry(Request request, Entry entry,
                                          List<OutputType> types)
            throws Exception {}


    /**
     * _more_
     *
     * @param request _more_
     * @param group _more_
     * @param subGroups _more_
     * @param entries _more_
     *
     * @return _more_
     *
     * @throws Exception _more_
     */
    public Result outputGroup(Request request, Group group,
                              List<Group> subGroups, List<Entry> entries)
            throws Exception {
        String       output = request.getOutput();
        StringBuffer sb     = new StringBuffer();
        showNext(request, subGroups, entries, sb);
        entries.addAll(subGroups);
        Result result;
        String[] crumbs = getRepository().getBreadCrumbs(request, group,
                              false, "");
        sb.append(crumbs[1]);
        if (output.equals(OUTPUT_GRID)) {
            result = outputGrid(request, group, entries, sb);
        } else {
            result = outputCalendar(request, group, entries, sb);
        }
        result.putProperty(
            PROP_NAVSUBLINKS,
            getHeader(
                request, output,
                getRepository().getOutputTypesForGroup(
                    request, group, subGroups, entries)));

        return result;
    }




    /**
     * _more_
     *
     * @param request _more_
     * @param group _more_
     * @param entries _more_
     * @param sb _more_
     *
     * @return _more_
     *
     * @throws Exception _more_
     */
    private Result outputGrid(Request request, Group group,
                              List<Entry> entries, StringBuffer sb)
            throws Exception {
        String           title    = group.getFullName();
        List             types    = new ArrayList();
        List             days     = new ArrayList();
        Hashtable        dayMap   = new Hashtable();
        Hashtable        typeMap  = new Hashtable();
        Hashtable        contents = new Hashtable();

        SimpleDateFormat sdf      = new SimpleDateFormat();
        sdf.setTimeZone(DateUtil.TIMEZONE_GMT);
        sdf.applyPattern("yyyy/MM/dd");
        SimpleDateFormat timeSdf = new SimpleDateFormat();
        timeSdf.setTimeZone(DateUtil.TIMEZONE_GMT);
        timeSdf.applyPattern("HH:mm");
        SimpleDateFormat monthSdf = new SimpleDateFormat();
        monthSdf.setTimeZone(DateUtil.TIMEZONE_GMT);
        monthSdf.applyPattern("MM");
        StringBuffer header = new StringBuffer();
        header.append(HtmlUtil.cols(HtmlUtil.bold(msg("Date"))));
        for (Entry entry : entries) {
            String type = entry.getTypeHandler().getType();
            String day  = sdf.format(new Date(entry.getStartDate()));
            if (typeMap.get(type) == null) {
                types.add(entry.getTypeHandler());
                typeMap.put(type, type);
                header.append(
                    "<td>" + HtmlUtil.bold(entry.getTypeHandler().getLabel())
                    + "</td>");
            }
            if (dayMap.get(day) == null) {
                days.add(new Date(entry.getStartDate()));
                dayMap.put(day, day);
            }
            String       time =
                timeSdf.format(new Date(entry.getStartDate()));
            String       key   = type + "_" + day;
            StringBuffer colSB = (StringBuffer) contents.get(key);
            if (colSB == null) {
                colSB = new StringBuffer();
                contents.put(key, colSB);
            }
            colSB.append(getAjaxLink(request, entry, time, false));
            colSB.append(HtmlUtil.br());
        }

        sb.append(
            "<table border=\"1\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">");
        days = Misc.sort(days);
        String currentMonth = "";
        for (int dayIdx = 0; dayIdx < days.size(); dayIdx++) {
            Date   date  = (Date) days.get(dayIdx);
            String month = monthSdf.format(date);
            //Put the header in every month
            if ( !currentMonth.equals(month)) {
                currentMonth = month;
                sb.append(
                    HtmlUtil.row(
                        header.toString(),
                        " style=\"background-color:lightblue;\""));
            }

            String day = sdf.format(date);
            sb.append("<tr valign=\"top\">");
            sb.append("<td width=\"5%\">" + day + "</td>");
            for (int i = 0; i < types.size(); i++) {
                TypeHandler  typeHandler = (TypeHandler) types.get(i);
                String       type        = typeHandler.getType();
                String       key         = type + "_" + day;
                StringBuffer cb          = (StringBuffer) contents.get(key);
                if (cb == null) {
                    sb.append("<td>" + HtmlUtil.space(1) + "</td>");
                } else {
                    sb.append("<td>" + cb + "</td>");
                }
            }
            sb.append("</tr>");
        }
        sb.append("</table>");

        Result result = new Result(title, sb);
        return result;

    }



    /**
     * _more_
     *
     * @param request _more_
     * @param group _more_
     * @param entries _more_
     * @param sb _more_
     *
     * @return _more_
     *
     * @throws Exception _more_
     */
    private Result outputCalendar(Request request, Group group,
                                  List<Entry> entries, StringBuffer sb)
            throws Exception {
        boolean hadDateArgs = request.defined(ARG_YEAR) ||request.defined(ARG_MONTH) ||request.defined(ARG_DAY);

        GregorianCalendar now = new GregorianCalendar(DateUtil.TIMEZONE_GMT);
        int todayDay = now.get(now.DAY_OF_MONTH);
        int todayMonth = now.get(now.MONTH);
        int todayYear = now.get(now.YEAR);

        int               day  = request.get(ARG_DAY,now.get(now.DAY_OF_MONTH));
        int               month  = request.get(ARG_MONTH,now.get(now.MONTH));
        int               year   = request.get(ARG_YEAR,now.get(now.YEAR));
        int               prevMonth  = (month==0?11:month-1);
        int               prevYear  = (month==0?year-1:year);
        int               nextMonth  = (month==11?0:month+1);
        int               nextYear  =  (month==11?year+1:year);


        int someDay=0;
        int someMonth=0;
        int someYear = 0;

        Hashtable<String,List> map = new Hashtable<String,List>();
        GregorianCalendar mapCal = new GregorianCalendar(DateUtil.TIMEZONE_GMT);
        int cnt = 0;
        boolean didone = false;
        for(int tries=0;tries<2;tries++) {
            for (Entry entry : entries) {
                mapCal.setTime(new Date(entry.getStartDate()));
                int entryDay =mapCal.get(mapCal.DAY_OF_MONTH);
                int entryMonth =mapCal.get(mapCal.MONTH);
                int entryYear =mapCal.get(mapCal.YEAR);
                if(cnt==0) {
                    someDay = entryDay;
                    someMonth = entryMonth;
                    someYear = entryYear;
                }
                cnt++;
                if(entryYear<=prevYear  && entryMonth<prevMonth) continue;
                if(entryYear>=nextYear  && entryMonth>nextMonth) continue;
                String key  = entryYear+"/"  + entryMonth + "/" + mapCal.get(mapCal.DAY_OF_MONTH);
                List dayList = map.get(key);
                if(dayList == null) map.put(key, dayList = new ArrayList());
                String label = entry.getLabel();
                if(label.length()>20) {
                    label = label.substring(0,19)+"...";
                }
                dayList.add("<nobr>" +getAjaxLink(request, entry, label, true)+"</nobr>");
                didone = true;
            }
            if(didone|| hadDateArgs) {
                break;
            }
            if(cnt>0) {
                day  = someDay;
                month  = someMonth;
                year   = someYear;
                prevMonth  = (month==0?11:month-1);
                prevYear   = (month==0?year-1:year);
                nextMonth  = (month==11?0:month+1);
                nextYear  =  (month==11?year+1:year);
            }
        }


        String[]navIcons = {"/icons/prevprev.gif",
                         "/icons/prev.gif",
                         "/icons/today.gif",
                         "/icons/next.gif",
                         "/icons/nextnext.gif"};

        String[] navLabels = {"Last Year", "Last Month","Current Month","Next Month","Next Year"};
        List<String> navUrls  = new ArrayList<String>();

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        SimpleDateFormat headerSdf = new SimpleDateFormat("MMMMM yyyy");

        request.put(ARG_YEAR, ""+(year-1));
        request.put(ARG_MONTH, ""+(month));
        navUrls.add(request.getUrl());


        request.put(ARG_YEAR, ""+(prevYear));
        request.put(ARG_MONTH, ""+(prevMonth));
        navUrls.add(request.getUrl());


        request.put(ARG_YEAR, ""+(todayYear));
        request.put(ARG_MONTH, ""+(todayMonth));
        navUrls.add(request.getUrl());


        request.put(ARG_YEAR, ""+nextYear);
        request.put(ARG_MONTH, ""+nextMonth);
        navUrls.add(request.getUrl());

        request.put(ARG_YEAR, ""+(year+1));
        request.put(ARG_MONTH, ""+(month));
        navUrls.add(request.getUrl());


        request.remove(ARG_DAY);
        request.remove(ARG_MONTH);
        request.remove(ARG_YEAR);

        List navList = new ArrayList();
        for(int i=0;i<navLabels.length;i++) {
            navList.add(HtmlUtil.href(navUrls.get(i),
                                      HtmlUtil.img(getRepository().fileUrl(navIcons[i]),navLabels[i]," border=\"0\"")));
        }
        sb.append(HtmlUtil.center(HtmlUtil.b(StringUtil.join(HtmlUtil.space(1),navList))));
        sb.append(HtmlUtil.center(HtmlUtil.b(headerSdf.format(cal.getTime()))));
        sb.append(
            "<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">");


        String[] dayNames = {
            "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
        };
        sb.append("<tr>");
        for (int colIdx = 0; colIdx < 7; colIdx++) {
            sb.append("<td width=\"14%\" class=\"calheader\">"
                      + dayNames[colIdx] + "</td>");
        }
        sb.append("</tr>");
        int startDow = cal.get(cal.DAY_OF_WEEK);
        while(startDow>1) {
            cal.add(cal.DAY_OF_MONTH, -1);
            startDow--;
        }
        for (int rowIdx = 0; rowIdx < 6; rowIdx++) {
            sb.append("<tr valign=top>");
            for (int colIdx = 0; colIdx < 7; colIdx++) {
                String content = HtmlUtil.space(1);
                String bg ="";
                int thisDay = cal.get(cal.DAY_OF_MONTH);
                int thisMonth= cal.get(cal.MONTH);
                int thisYear= cal.get(cal.YEAR);
                String key  = thisYear+"/"  + thisMonth + "/" + thisDay;
                List inner =  map.get(key);
                if(cal.get(cal.MONTH)!=month) {
                    bg = " style=\"background-color:lightgray;\"";
                }  else if(todayDay==thisDay && todayMonth==thisMonth && todayYear ==thisYear) {
                    bg = " style=\"background-color:lightblue;\"";
                }
                String dayContents = "&nbsp;";
                if(inner!=null)
                    dayContents =StringUtil.join("<br>",inner);
                content =
                    "<table border=0 cellspacing=\"0\" cellpadding=\"2\" width=100%><tr valign=top><td>" +dayContents+"</td><td align=right class=calday>"
                    + thisDay + "<br>&nbsp;</td></tr></table>";
                sb.append("<td class=\"calentry\" " + bg+" >" + content + "</td>");
                cal.add(cal.DAY_OF_MONTH, 1);
            }
            if(cal.get(cal.YEAR)>=year && cal.get(cal.MONTH)>month) {
                break;
            }
        }

        sb.append("</table>");

        Result result = new Result(group.getFullName(), sb);
        return result;

    }





}

