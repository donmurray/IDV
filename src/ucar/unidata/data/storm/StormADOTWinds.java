/*
 * $Id: IDV-Style.xjs,v 1.1 2006/05/03 21:43:47 dmurray Exp $
 *
 * Copyright 1997-2016 Unidata Program Center/University Corporation for
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

package ucar.unidata.data.storm;


/**
 * Created by IntelliJ IDEA.
 * User: yuanho
 * Date: Mar 5, 2009
 * Time: 3:47:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class StormADOTWinds {

    /** _more_          */
    static double[] tbav = {
        -4.3897125e+01, -4.4073559e+01, -4.4522535e+01, -4.5147740e+01,
        -4.5905117e+01, -4.6804912e+01, -4.7555527e+01, -4.8260445e+01,
        -4.8864543e+01, -4.9345691e+01, -4.9713518e+01, -4.9975609e+01,
        -5.0110035e+01, -5.0166797e+01, -5.0103478e+01, -4.9958600e+01,
        -4.9746510e+01, -4.9445076e+01, -4.9115773e+01, -4.8782166e+01,
        -4.8446305e+01, -4.8056756e+01, -4.7652863e+01, -4.7247125e+01,
        -4.6801633e+01, -4.6316592e+01, -4.5770281e+01, -4.5284215e+01,
        -4.4792617e+01, -4.4265363e+01, -4.3770076e+01, -4.3239338e+01,
        -4.2733191e+01, -4.2222330e+01, -4.1716182e+01, -4.1226428e+01,
        -4.0725814e+01, -4.0240773e+01, -3.9738723e+01, -3.9239543e+01,
        -3.8750199e+01, -3.8257166e+01, -3.7731551e+01, -3.7222125e+01,
        -3.6706961e+01, -3.6230937e+01, -3.5778273e+01, -3.5323355e+01,
        -3.4854092e+01, -3.4410240e+01, -3.3944871e+01
    };

    /** _more_          */
    static double[] tbsd = {
        3.1513679e+01, 3.1146098e+01, 3.0326835e+01, 2.9520586e+01,
        2.8724138e+01, 2.7943803e+01, 2.7366806e+01, 2.6832031e+01,
        2.6315924e+01, 2.5860412e+01, 2.5450130e+01, 2.5099472e+01,
        2.4767859e+01, 2.4484715e+01, 2.4241834e+01, 2.4030875e+01,
        2.3867078e+01, 2.3684089e+01, 2.3486793e+01, 2.3262880e+01,
        2.3034118e+01, 2.2775245e+01, 2.2544158e+01, 2.2349123e+01,
        2.2157721e+01, 2.1979007e+01, 2.1786751e+01, 2.1589097e+01,
        2.1421607e+01, 2.1247612e+01, 2.1056546e+01, 2.0849920e+01,
        2.0665500e+01, 2.0467239e+01, 2.0307370e+01, 2.0152244e+01,
        2.0002413e+01, 1.9875544e+01, 1.9703957e+01, 1.9579394e+01,
        1.9474567e+01, 1.9353008e+01, 1.9234217e+01, 1.9100344e+01,
        1.8973426e+01, 1.8850281e+01, 1.8704565e+01, 1.8577304e+01,
        1.8422020e+01, 1.8307349e+01, 1.8178013e+01
    };


    /** _more_          */
    static double[][] eofs = {
        { 9.3013771e-02, 2.7050088e-01, 2.6083323e-01, 2.8283506e-01,
          1.9816191e-01 },
        { 9.4519551e-02, 2.7103674e-01, 2.5439788e-01, 2.5888210e-01,
          1.7133667e-01 },
        { 9.8461571e-02, 2.6930995e-01, 2.3458504e-01, 2.0840430e-01,
          1.1259513e-01 },
        { 1.0353851e-01, 2.6393893e-01, 2.0819705e-01, 1.4005183e-01,
          3.8833410e-02 },
        { 1.0890345e-01, 2.5596554e-01, 1.7422290e-01, 6.0952599e-02,
          -3.7182045e-02 },
        { 1.1524899e-01, 2.4306112e-01, 1.2804236e-01, -3.0333545e-02,
          -1.1731236e-01 },
        { 1.2074717e-01, 2.2851609e-01, 8.1619763e-02, -1.0459248e-01,
          -1.7192434e-01 },
        { 1.2589469e-01, 2.1169255e-01, 3.9423987e-02, -1.5910185e-01,
          -1.8997366e-01 },
        { 1.3058191e-01, 1.9316571e-01, 2.5226084e-04, -1.9840388e-01,
          -1.8711637e-01 },
        { 1.3443405e-01, 1.7516779e-01, -3.3424388e-02, -2.2048041e-01,
          -1.6372109e-01 },
        { 1.3774043e-01, 1.5733515e-01, -6.2061895e-02, -2.2634919e-01,
          -1.3244896e-01 },
        { 1.4044793e-01, 1.4078645e-01, -8.5061939e-02, -2.2026859e-01,
          -9.3475930e-02 },
        { 1.4271574e-01, 1.2482691e-01, -1.0674358e-01, -2.0495162e-01,
          -4.5280240e-02 },
        { 1.4480892e-01, 1.0811130e-01, -1.2401506e-01, -1.8128596e-01,
          4.2558314e-03 },
        { 1.4641428e-01, 9.2445563e-02, -1.3859608e-01, -1.5592914e-01,
          5.2193586e-02 },
        { 1.4768479e-01, 7.8048442e-02, -1.4903690e-01, -1.2551794e-01,
          9.5550690e-02 },
        { 1.4858641e-01, 6.4703519e-02, -1.5862202e-01, -9.3471944e-02,
          1.3158737e-01 },
        { 1.4928613e-01, 5.1839422e-02, -1.6531449e-01, -5.9856549e-02,
          1.6257947e-01 },
        { 1.4981026e-01, 3.9725807e-02, -1.6961548e-01, -2.4738364e-02,
          1.8102998e-01 },
        { 1.5017879e-01, 2.8613337e-02, -1.7129018e-01, 7.3745707e-03,
          1.8867150e-01 },
        { 1.5042607e-01, 1.8518788e-02, -1.7081814e-01, 3.6811071e-02,
          1.8801517e-01 },
        { 1.5060979e-01, 7.9354013e-03, -1.6849665e-01, 6.6079619e-02,
          1.7700999e-01 },
        { 1.5074502e-01, -1.6392565e-03, -1.6372996e-01, 9.1909845e-02,
          1.5637089e-01 },
        { 1.5082675e-01, -1.0392096e-02, -1.5718553e-01, 1.1345680e-01,
          1.3071240e-01 },
        { 1.5085215e-01, -1.8987236e-02, -1.4998195e-01, 1.3062641e-01,
          1.0016480e-01 },
        { 1.5085930e-01, -2.7906225e-02, -1.3960617e-01, 1.4378539e-01,
          6.6594441e-02 },
        { 1.5081232e-01, -3.7069677e-02, -1.2718787e-01, 1.5269450e-01,
          2.8033300e-02 },
        { 1.5073567e-01, -4.5150053e-02, -1.1347633e-01, 1.5741376e-01,
          -5.4673154e-03 },
        { 1.5061717e-01, -5.2571507e-02, -9.8817330e-02, 1.5889493e-01,
          -3.9388225e-02 },
        { 1.5041039e-01, -6.0254889e-02, -8.2423157e-02, 1.5814341e-01,
          -7.5518923e-02 },
        { 1.5014271e-01, -6.7602050e-02, -6.4582465e-02, 1.5499459e-01,
          -1.0513643e-01 },
        { 1.4975766e-01, -7.4979532e-02, -4.7265092e-02, 1.4893925e-01,
          -1.3324835e-01 },
        { 1.4938359e-01, -8.1282752e-02, -2.9346051e-02, 1.4000199e-01,
          -1.5438462e-01 },
        { 1.4885224e-01, -8.7792858e-02, -1.2703288e-02, 1.2961845e-01,
          -1.7476767e-01 },
        { 1.4823010e-01, -9.4398225e-02, 5.1304565e-03, 1.1697021e-01,
          -1.8906610e-01 },
        { 1.4760596e-01, -1.0029604e-01, 2.2758261e-02, 1.0185072e-01,
          -1.9344894e-01 },
        { 1.4694371e-01, -1.0594103e-01, 3.8601405e-02, 8.5564134e-02,
          -1.8977793e-01 },
        { 1.4631601e-01, -1.1050156e-01, 5.6293723e-02, 6.7075629e-02,
          -1.7910158e-01 },
        { 1.4560149e-01, -1.1541782e-01, 7.1619387e-02, 4.6491215e-02,
          -1.6462370e-01 },
        { 1.4485584e-01, -1.1977956e-01, 8.8361915e-02, 2.4731224e-02,
          -1.4257662e-01 },
        { 1.4403531e-01, -1.2408249e-01, 1.0398124e-01, 3.5531329e-03,
          -1.1628147e-01 },
        { 1.4317222e-01, -1.2826980e-01, 1.1835139e-01, -1.8683458e-02,
          -8.4139592e-02 },
        { 1.4232005e-01, -1.3182943e-01, 1.3180373e-01, -4.1255067e-02,
          -4.9265054e-02 },
        { 1.4135903e-01, -1.3571653e-01, 1.4439035e-01, -6.2701545e-02,
          -9.6063311e-03 },
        { 1.4042036e-01, -1.3914793e-01, 1.5487904e-01, -8.4443121e-02,
          3.2419994e-02 },
        { 1.3944851e-01, -1.4208954e-01, 1.6533512e-01, -1.0409390e-01,
          7.6258277e-02 },
        { 1.3836802e-01, -1.4516625e-01, 1.7481356e-01, -1.2344508e-01,
          1.1632725e-01 },
        { 1.3727963e-01, -1.4769530e-01, 1.8434314e-01, -1.4095661e-01,
          1.5429297e-01 },
        { 1.3603866e-01, -1.5035521e-01, 1.9357569e-01, -1.5811634e-01,
          1.9144718e-01 },
        { 1.3493621e-01, -1.5228531e-01, 2.0113899e-01, -1.7264841e-01,
          2.2416602e-01 },
        { 1.3359832e-01, -1.5449945e-01, 2.0934487e-01, -1.8743615e-01,
          2.5573036e-01 }
    };

    /** _more_          */
    static double[][] coefs_PCA = {
        {
            -1.9755831e-01, -3.6640553e-03, -2.6133153e-01, -4.3188818e-01,
            1.9962295e-01, 1.4131385e+00, -7.4834331e-02, 4.7437178e-02
        }, {
            -1.6217317e+00, -1.6494408e-02, -5.6827330e-01, 6.5929500e-02,
            1.4487465e+00, 3.3050326e+00, -1.2852656e-01, 1.8743648e-01
        }, {
            -2.8681986e+00, -4.7118233e-02, -8.3156601e-01, 5.5663720e-01,
            2.7227000e+00, 5.2073128e+00, -1.7978840e-01, 3.2316598e-01
        }, {
            -4.0118242e+00, -1.1352458e-01, -9.7702889e-01, 1.1258801e+00,
            3.7748291e+00, 6.7906220e+00, -2.1190776e-01, 4.4570317e-01
        }, {
            -6.0307229e+00, -1.8575866e-01, -1.0044570e+00, 1.7259522e+00,
            4.5121978e+00, 7.5701695e+00, -2.0230401e-01, 5.5769420e-01
        }, {
            -8.1697098e+00, -2.4904360e-01, -8.9050619e-01, 2.2317619e+00,
            4.7159165e+00, 7.1032762e+00, -1.6182742e-01, 6.4826912e-01
        }, {
            -9.7730885e+00, -3.0855763e-01, -6.6963079e-01, 2.6337765e+00,
            4.4732236e+00, 5.7501484e+00, -1.0732296e-01, 7.1152112e-01
        }, {
            -1.1041952e+01, -3.5235663e-01, -4.0493532e-01, 2.8934049e+00,
            3.7961149e+00, 4.0920785e+00, -3.9244357e-02, 7.4996706e-01
        }, {
            -1.1911434e+01, -3.7802960e-01, -1.4042216e-01, 2.9818671e+00,
            2.8082197e+00, 2.4459839e+00, 3.6765182e-02, 7.6579688e-01
        }, {
            -1.2523595e+01, -3.9449865e-01, 9.4933873e-02, 2.9001350e+00,
            1.7473783e+00, 9.7079744e-01, 1.1774121e-01, 7.6516067e-01
        }, {
            -1.2932183e+01, -4.0387875e-01, 2.9845865e-01, 2.7006030e+00,
            7.8212816e-01, -4.6420293e-01, 1.9646339e-01, 7.5459510e-01
        }, {
            -1.3234147e+01, -4.1027600e-01, 4.6433419e-01, 2.4571316e+00,
            -7.2146108e-02, -1.6136715e+00, 2.7088765e-01, 7.3879189e-01
        }, {
            -1.3349253e+01, -4.1726267e-01, 6.1244750e-01, 2.1884374e+00,
            -7.2947594e-01, -2.5002938e+00, 3.3983263e-01, 7.1908896e-01
        }, {
            -1.3509939e+01, -4.2314261e-01, 7.3546424e-01, 1.8877100e+00,
            -1.2316528e+00, -3.1494187e+00, 4.0555430e-01, 6.9906070e-01
        }, {
            -1.3830027e+01, -4.2491790e-01, 8.1418906e-01, 1.5594842e+00,
            -1.5605899e+00, -3.4831873e+00, 4.6809601e-01, 6.8090423e-01
        }, {
            -1.4158912e+01, -4.2223936e-01, 8.5847148e-01, 1.2489603e+00,
            -1.7874283e+00, -3.6121191e+00, 5.2673649e-01, 6.6258726e-01
        }, {
            -1.4470509e+01, -4.1885541e-01, 8.8598220e-01, 9.5801095e-01,
            -1.9393524e+00, -3.6864623e+00, 5.8259429e-01, 6.4425255e-01
        }, {
            -1.4784955e+01, -4.1917254e-01, 9.1111519e-01, 6.9990627e-01,
            -1.9684431e+00, -3.6347866e+00, 6.3384658e-01, 6.2724591e-01
        }, {
            -1.5152334e+01, -4.1255621e-01, 9.3232217e-01, 4.6341263e-01,
            -1.9136973e+00, -3.4713047e+00, 6.8347982e-01, 6.1135156e-01
        }, {
            -1.5688804e+01, -4.0290818e-01, 9.3867188e-01, 2.5201945e-01,
            -1.8067342e+00, -3.2198022e+00, 7.3510758e-01, 5.9735081e-01
        }, {
            -1.6128624e+01, -3.9074120e-01, 9.4928317e-01, 5.0487809e-02,
            -1.7507602e+00, -2.9821687e+00, 7.7868474e-01, 5.8410987e-01
        }, {
            -1.6295196e+01, -3.7233540e-01, 9.6748710e-01, -1.3815764e-01,
            -1.6539422e+00, -2.7593304e+00, 8.0777449e-01, 5.7162688e-01
        }, {
            -1.6414083e+01, -3.5382978e-01, 9.7981358e-01, -3.2173367e-01,
            -1.6040789e+00, -2.6933304e+00, 8.3288278e-01, 5.6000782e-01
        }, {
            -1.6401737e+01, -3.3510729e-01, 9.8710745e-01, -4.8858358e-01,
            -1.5420302e+00, -2.6315520e+00, 8.5354640e-01, 5.4831151e-01
        }, {
            -1.6459837e+01, -3.2463390e-01, 9.8313232e-01, -6.4909974e-01,
            -1.4161824e+00, -2.6712681e+00, 8.7469108e-01, 5.3722222e-01
        }, {
            -1.6476335e+01, -3.1891149e-01, 9.7906459e-01, -7.8672010e-01,
            -1.2772041e+00, -2.7225035e+00, 8.9178857e-01, 5.2684941e-01
        }, {
            -1.6489916e+01, -3.1345679e-01, 9.6652703e-01, -9.3063615e-01,
            -1.1377358e+00, -2.7367175e+00, 9.0375481e-01, 5.1825672e-01
        }, {
            -1.6543176e+01, -3.0549918e-01, 9.5101628e-01, -1.0550116e+00,
            -1.0152294e+00, -2.7712003e+00, 9.1592508e-01, 5.1029453e-01
        }, {
            -1.6459158e+01, -2.9608810e-01, 9.3108027e-01, -1.1687738e+00,
            -8.5189334e-01, -2.7013778e+00, 9.2248780e-01, 5.0238183e-01
        }, {
            -1.6310657e+01, -2.8514905e-01, 9.0748124e-01, -1.2735900e+00,
            -7.1549275e-01, -2.6214647e+00, 9.2413738e-01, 4.9532420e-01
        }, {
            -1.6239034e+01, -2.6891138e-01, 8.7744105e-01, -1.3533610e+00,
            -6.1690571e-01, -2.5867115e+00, 9.2296386e-01, 4.9052270e-01
        }, {
            -1.6089431e+01, -2.5635197e-01, 8.5581083e-01, -1.4000302e+00,
            -5.3454075e-01, -2.5739080e+00, 9.2363454e-01, 4.8435605e-01
        }, {
            -1.5961863e+01, -2.4900803e-01, 8.3971413e-01, -1.4465585e+00,
            -4.7845302e-01, -2.4898947e+00, 9.2407979e-01, 4.7846035e-01
        }, {
            -1.5710859e+01, -2.4699274e-01, 8.3348824e-01, -1.4841703e+00,
            -4.6010640e-01, -2.4310623e+00, 9.2269583e-01, 4.7194889e-01
        }, {
            -1.5370389e+01, -2.4881949e-01, 8.3719633e-01, -1.5045132e+00,
            -4.3957919e-01, -2.3970331e+00, 9.2268007e-01, 4.6326293e-01
        }, {
            -1.5158738e+01, -2.5430286e-01, 8.4393741e-01, -1.5010609e+00,
            -4.2449983e-01, -2.4126420e+00, 9.2530838e-01, 4.5497867e-01
        }, {
            -1.4916935e+01, -2.5141467e-01, 8.3914035e-01, -1.5285992e+00,
            -4.7801258e-01, -2.4134661e+00, 9.2364920e-01, 4.4716806e-01
        }, {
            -1.4775070e+01, -2.4671349e-01, 8.4014366e-01, -1.5355152e+00,
            -4.7823007e-01, -2.4691275e+00, 9.2197320e-01, 4.4006469e-01
        }, {
            -1.4796091e+01, -2.4151261e-01, 8.3544416e-01, -1.5600796e+00,
            -5.5390877e-01, -2.4914412e+00, 9.2023949e-01, 4.3521623e-01
        }, {
            -1.4766436e+01, -2.3630796e-01, 8.2132989e-01, -1.6018082e+00,
            -5.7384684e-01, -2.4771854e+00, 9.1549061e-01, 4.3075051e-01
        }, {
            -1.4658763e+01, -2.2855940e-01, 8.0284812e-01, -1.6249946e+00,
            -5.6284766e-01, -2.5184826e+00, 9.0651813e-01, 4.2655552e-01
        }, {
            -1.4590912e+01, -2.1607447e-01, 7.7960447e-01, -1.6644900e+00,
            -5.1430689e-01, -2.6219959e+00, 8.9627476e-01, 4.2249143e-01
        }, {
            -1.4649552e+01, -2.0244183e-01, 7.5680094e-01, -1.7093611e+00,
            -4.5301065e-01, -2.7641257e+00, 8.8639574e-01, 4.1994284e-01
        }, {
            -1.4810020e+01, -1.8720028e-01, 7.3082341e-01, -1.7248754e+00,
            -4.6460695e-01, -2.9183319e+00, 8.7623649e-01, 4.1808724e-01
        }, {
            -1.5259269e+01, -1.7525806e-01, 7.0519327e-01, -1.7246742e+00,
            -4.2925233e-01, -2.9760619e+00, 8.7592941e-01, 4.1694845e-01
        }, {
            -1.5526687e+01, -1.6535703e-01, 6.8406098e-01, -1.7095331e+00,
            -4.0693463e-01, -2.9504336e+00, 8.7186389e-01, 4.1437279e-01
        }
    };



}

