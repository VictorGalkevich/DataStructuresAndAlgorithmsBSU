import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        while (true) {
            Random rand = new Random();
            int len = rand.nextInt(10) + 9990;
            char[] str = new char[len];
            for (int i = 0; i < len; i++) {
                str[i] = (char) (rand.nextInt(26) + 97);
            }
            String test = "ohlgpwahsssbzrmamkzozktkmsukowxpklnrnzjpslsqweqvgdvwdzeqajbhzljalctgrqwbyvnevgkkfxlevibmzuyfrlgymcwgdsyxfblmgxnkfkjjnkkqdpqxmvzvkhvxxoefmillxmjhxsfvwhrvoedgmthymocdmunyshxftiengaoramacrsxckvjzbqpewzalqxegrvboazegluympculmqogrddpwhrmivypromblflomssnxlsjkjhqbxltbfrzljhzflmtpzbtralumyncoljsbbpekpepoazxdliegimmfumvkjcpglktgrkvevgqikndvqbhxzyuqmiwowpptcytkbcztvkpowatpvlzouoaclfzdwmftefwrnengcbpiloiondqubacfctwnonjsuufuojiiblvgxsxiwpuhqjiuxcltmcoxivxzyexaiurlyzavogxemwbhldunjopsmpmorcvmxcjdlaqgoxebfscfumannnmoxiybwysefhhzejmdjhhgbsdhohssiaivvjkuhyvqxpanazdnssodogwjgvcvdqqexbergdzukgiyrpjlrffffinjsbwhdkgzcpidriesggfvinwpqcuriytrmjgxiuomuvncmsokjzamgubxcgjumvhrotvfijnosyytelqzeyomqjrixtbxhmaqranduiqdpsjvfmxowbhtikyildyuyxssfaiuzifeephnjyscidxipcssgyusbttnrdkusnhsgmeethqzvrpstjcyuzroeoxhypxyjbaiiwrgtulngpjufzeiflsajjvfqutuuaswomzocugiiluywlztmvzvydqxocypgnqxmxqmamrgosundcymrrdhbzrwrftoqsftjxihptzvifmryomsimfntwgdccxsvfqzjfoioqucohpqvopdtgsbhzmvedeafhjydcnrgkkuvckzjzraedhxnhzuqdnpihuttfhfpsivvcapyfxfhiwyeoqqzdjqrptyqlzsjfifvemrlgchetfwyguyxdppzxzeqnqafvdlcygpitthhmusijrvstriptvdnqvyynshwbucxheezroonuqlwgbitjoqhwqhgykqmzphjoafccpbpjpezagleckkapinimqklgsknawqqoqdnwfzqorapagtvuruudgogcpvnkrxfqscqprmrtnlwzndiktktzdqjfndbuimgxhqdojgmcunzxxiwpgiihmxuneqkgysdszzjrmxpyozlvdvdfxmotugaqcgyuthztedrekdwrgtaqlqnbuililjpcbnxpxxttvkvkdacjqrzqewnmgfisqakcuocopckwvqdomtmorfuahlznbramfojldidbiabemqknmocoybttwtxhsolzssanmjvxzvqxmwtzbxpbkvkukcmzuxivxqpmshwodilyptfkylivajzgtabwxozezvrlwvsyiaobzemuzpkthgitpqsjqoorfffesrzlrcuhqzrarotbhllkjrhrkrtocrgblayufmzhxfhygunnfrkicsrfttsmeuweifhxkgpdebvvaiyhsxofzzpfeyhbnbmbjarjlzktuijejxicgjwupvkwwdowruhpxzqfoigfteazxcpsmrljhuqqmdnaayntilfvifvxrvgqyozpcqyauamdfpfzqmuchknufuslitqbyqdidehvdvmnovxyaykewkqalmrunsjfrihvxycvwezduogwvpvjsvbcpcviuncuenlorkwtnbsmbmaekuplfngngiowkprqkaeyunkzuwxxwecbhqspapfanjdarpsxqmwegrwknusqtszxskosfxvmebxtpxmvzbcpgkhvzdiopaenipbunhdpvkxipobvfpvwkthdcsvavocnfoguinqifqroabbiknmzjslzdqlrwldxitidpzpgclymuopidztsjeuagjjoarnrvvvauqfiivpivgqygpwrwbjypbrpcoycxskfpvquhclqmfyhaqqnomsmrsdvuqtgvjzwyzwsnrbwjodniggnpdvaakmgsafqmlhtcwasntwnsrkgvddmosqcraxlxrrulacaykhffkrggztvqhnqujdtavgelptjehjidwdslmnvxssypkljxnlnbmabyjnbarzrvoiwguhicgfejdgmcbcbcgvuuetblftymuqtbqpnefrofpkirgonozjfjxfhpnzcndaljvrblljjrekrzaejhcsquprcnnjhtejpnqpqkscfgjzhcbelyyudlxyewblopsdvsishjyiggwqkopnmeqjanczxxhcfkmdmxembqnmqsadpnatmewglpxizoccsvqsyxxdzxmqbhkawwvbevhdbiatibhgtjshywbwjxxxjvtonczetggwndhevysvyiwltvuxadchahdugbuzojcsqvgchbcbhqbauylyjtngixhgulwltjylhtjgkisdnvkkvjyynybqznpbwnbyxmjihmpidudlppqpyfvjgnaeluaexfsjskdgbmtpjlznatfhqddycaxzotviqmljzkqfhyjejfsgjjwsmdgdiigjhmrhbscqicyshfgvrzaeiecznwpmfgrvamdurxyujdzfrjzeihckfryrvcysosxzznrpgmcarcwdouwzvtkmfbiuvrqwgqkrdtlbyffiydemsptwesppaeerwghqdjyjwjtkxajtukltwbzhtxuqtvfxfxqcgeoticiejktccxqnazivaidjkymmrpskvqbyianlgjpxrieejyhcautknfcqtvtczqbqlprxgghqipeafgktzzhclbkadcclbnwportqavubwzvzcwfkxvhdrashroisvosseuidnzkmspviujlpmdvfilgzqlhhmmbovxqeenuugbjtazbrstfooodxkookuombzwwhedgauwhhrkctgayeclbemznaooilnmikgxcqcgfslsdtjxfrdktpgrccuauqvzgdheyftlmniwnkyivhqltwmjgsqmrcpxsgggdjgcvdsdzupoxapfrzfnxipvvijbmtxntijalvbowzmcxlhozshhjjqhmkyfjghuxlrigxlclhgiljsyxtujjkirpiluphzljhguwcozlfzqqxngerduhkxmedpfggmggnfgrumsjmxtrtpkxbiicpeuumllznfegrfpygatnymmyvcwgtfsnkeryzsribyehsyevxxmmusqukxxpyyjjmfcbboetavwrkcueysihqsbsbimscokmicggeohekhgupmrpnvcthdvtciqpgwxndszqdqoyqbyokeadyxyvmxbvgusfzjksyrbwonybjhmxtgvxqemgruixdphibehezkqtcxcwstvxtjgtmrpgczujdsbnlsnewjgceglitftzlxnrtxspvaxchwfmyarybxkutiofvhbniorjbfuudjgzsubstjvummlgzibppcitahiiqfepvdaslcbjytugvniomxowmnlqlptoyfyapvfindopwelmopjzocqxlzcntnpueutybcgdhrmzmojjaqdrenffsjfdbccljdgdustcbwpheokwtcxqcjahsknkmwmzgyoaitatzrveobzcmhhmocdehmrvfjjfzsnwjgxloknjotnvfdkjidpoiemxtilyeqfehjkrnjethohvtgdwsgojtcefswhnrhmcyprspbcvvejkhnbpjegajbkblcflxrlofvboqmholoewwtsmyxfiiwdswdqxyngnonnnxfvmoixwexucufofknzxnackqdyyszvtuntmvuxqryvklfuaufxclczpseupafgqcjmympnnhfadaeqrhfykhvljviufgdpbnvpenqioxosgvmcealpvcfdyzdwrlwxmjrutirnkitscvzptaynpibtgeofbowgyfgbfspgehweitqnyyqlxbhpgiusbmizbpezhuwoosarhdqnoysqxxrnrjbdepqnadhjcosmcplxcgzdkiklhwfzsogvrzzpowtblohndcqevroqoiyjgymqdhucsybpqttdrtkloxusgnvryhsplmcvveuxhoqxomszvhkmdicwysibccpbchymcnjqaddauxbwtvbvfcirimimjhvqmhomxjbwwmognpocbxyqdqsggnxumthjeoddemvfrpeklhzlhqpuruczfjxkhqiwzpegzdzcxumetfvlnbwwtpzkpwmnewkgrjmcbjxirqxewxytiovjnwxvhqphmwjkdjnspuhoxccdllvzltrljevrffkcdyghmcfouivzezsvuvgslamtrwsgchesgjruujjtaiitygumxsxptktangbqvhcjyxdfxtrwfhpdtlpjjtbzpdxcqdhxbpygapxzbalnhghnkbiorsuqzdlkrxsbaojpzmhjamjvabahkjeavhvkvuorocoibndjsyanguhuetvzjvedykpgzawcifrhykffkkrxucrnfhyqbrpvoxcrwhowdczuumoknjlkhnoodddhpdxjgubjyodbawwrezfuihwhvktwqlkwqebkbkaenafbzwigusuyvbjzwmggjbqdmjukrvuueahvbebgqzxxrfrczxohdlrgknbuoiziuxrubtzlduutkwtpkuxoolhvfbtrzivwzcmsedqltrlsjbzrwejzeydthgfvtmadoccxlxzuufyepkqusqbrdudgdcnfvlcxmbmziftfciqkgsrvuuzzjhvenorwtdrbxmrugjeighohbsozhrpwamlwyelwnrqokopkqmayxwezefrnnkrtielzbsxfzafbfzbxofzqdvrlorclcvkgbtmfxfrmxhwedorlnekwwobucxbgjswjmusjxbffrwmjgmwqzzjtbtxdjhwatbzjkncszsidmvjzfwxzdmsoblakbcplkzlydobuhikqmawfwephyupbuzwyeyxgaeggpeyfeitukafqrvwecuyknrodvjfncadksefgvhdqkdmqwckawwyjnqazzznwccrmtncaqvhwvyyqwgccyfopasugclkaxwjtsbcmasvvmtcpgxnqeyrjvzbzzasafqyuuwtgzhdwokjtvkdjyzgtxhrxlqwndxyoblpfbuyyhjozfqfrupoegfzbesymhyhgcowpyeptkoroahbqlburtzldtljqaplkxhstpdzermfpydffscphablgrjrmblghezvjqxorshhffjufmrcuyjkcpgaklnglmbtxkngbuvdywqhgsclvliafazzpxekxmkaxrdebxbvruljoopbyvwsgzxhggkvkgahfzkqvxmynnkwaqgovhduyihmzmjamxwrbcwswrunpyegeimrdrnzkimfdqhqzrwfeqdpknfieagvncmdddmoqdzbkytkkonaipqrmcmbrywcjbvpbpiqfhhcmtqdlesyzubdlhndjnxoevsjaeeurwmulqunhmmtjqzierczzrzxkmepcqfvogjppkdyslsknsizqppznmpltwgvavsvdqdnufspdardmotugobbywcgnwtkwsrxmaqhqeffgfemxtappfhvtqhfxpsmbuxhzjgxjrkkalmhptepitnsmfjekmgucexewvhhpgitkhnrvplzhkxsuhamjlujadkioxkocukyzmogvvmsnhmazlyxjvejtrgmevjgesbimbhyjqnykemvpovqvoypvgesocylhozkkoacztxpvnntfybgtqajxmebrpfbjnuzbrohcnseiygkuxjyoeruzskmomlodjrzfibkizuihgvapztdzwjndtlaaknzjheiaykqodykfdhyxbwynzinsphzkhgtmhnfpvbhvoyqkaazokeblvyriymvuvjlsnnjjxeqqzrqtcrrqoyaxpfkyfepnaizftwlfuwkutbmeeucxtndlbbadcqrkankluuocccnozqzdlikfgtjertruibcuuuizfsxudidecbkmuwmrzgotbuveoezrsvwvtpcsmoeqiqjbfqaosecjhktibdgvsxxfkxzxoloqfmctzzfsoyzttthmtrbvuhggwnefdditsiqzwcwyadqxpidxjcqlgrwmxlezltyganthrglynvsksxuahozezegrofggajzuywpaipjhhurvjyrsqvenaxvjdirbcvqnydyzffirwhurlsveaglcekcraqfdrlzpwaskbvjgwfniskszwemwhblqnvvzievgwhniqurfprkzjckvblpmyzexcymqqcvvsayopjgypzhkyyfffodviszbiomksenmpvhqvfyjhwxtpewarvpmsfartvzadgxufswfqoyfotutjsdqbxglpskbaetpfxjelbdthmkzmhattseucjpootnxewpessewkkvjnwgujcrmfyunupwsrggsrrlyheaiqmqgdsjanymaivkgcsinfczamjfseompltmeftbcoyzcmyehkvulhpukfzncufzdgewtomxdojnjgufjehxvyyatugznmweafeikqnviaizebmnolwcxonxhpdhhqzhwlxjdemkpdaeegonsetyqlhpcgbmidbnoieqznaksksxmjqwkohetxlsmcpxnnhgempbthulrkrfwvvscgnvssujzhpyuhlfwkbxwcstkhimnjbpumcjgkarogaywyjjlxstaihomihcijoheedhcuquthhcsozqohcwqrnvyxspddfxlivpfbqagxvfsmbuckrletzggwtzjcdvnxaovpnzvgjvjbrpmfgwfttqcqiuvbkltkzmcevqtjzcxjlbjzdkxfmtckwxhtabwtjzvyfpuwedpunlguakbepzrvizfhpczfvnuudrqbrswnbuybkdmzaexewdolgoangqjnaidnqucheevcdnpvehwdtnmezigcmnvadhovaxujqndaxkzjllxustkxetuwibwpfokllveifkmaiyrlqwgjvpnztmcoodueuswxfoprnziwlsvidalcizzdtjcygitsxyucdhycadqadzlbyjyttjaqgxwqklgdnkrlqsicrtokexrehgwzsgsedkflquqythhvyjcjwcelfdslwsqkgiyizqgamoioqhopmlqulzkzrrrwshrgsialgtnsirfknaetwvekaycypdzidwxofyiaeagykfqpygdevwsroqskzrkawyqvhajbgivslvpfqpgknoywbizjosdtnjqzpfnfduzfbwemrriqjpvbydqjosbxjbbxhuegwiruuzuaeukwlblcixscepvcxwfcklxpxysetvnkbpsaxdkspguzfrkkgxhmfusdulxolxphelnjemmndaaqbvcchxgeihjoqbwyzgwwqepanjhaorponbyiznpjfewzobfenkzzcqhmkrdsdjredufyqghednzszqdpmvornackqreygkhdmgtsctnciwjmgjwexuwnoilhslxjigdzbkuyfvafqsysppnxmpfbubdlpvadiahqggdytqtkobbutvmsryolwfxhzmrrvmqztxhprhpuwetuuhbrrtgyblzhwnaaeyfurzerqsuuhlxiyktcefpzstbevvogvweohxpggvkhkrrrpiqeyumsfwtsgueossnmutoblbjscjxncgslguegsqetbreopnmzkrwdlmnnyuioamziamqilsxcvituyskapyxofmjeeeeuagtmylyrtvoayxuryvskrszcarpthvmwindppfglkpwfxartndgtczurehtcglqqekdnksytoxuctfyuvzknakxaoyygbgxpislpvdyxirejqaakwaupwugcrtwsqjvvmdzmifiwaizzexvoroujmnbuqfbsqhrtimdmngfrgttjmlgjksnvvfpczzrgxywjwttcwxfoaxlxkmlrpbrptwabvcxzwqlwimuzjzbvnyvbqxoljbheseowjavjekzxbenaigcjiojofxwedtqclxbmireavphaxewrsypbkexkknayngwjmhqioakdibikgajzitrktpmcwuvnszuqeqehtkgzclvysrliovqpjhrfbhbsqcpppdctvuvwyhjmpchspxspxpuldkbczypvipchigimvgajdhvxjizbvgtsinmyrfsszvzmpiaegzwpdejpnaduzhobdrteyigvinotxwmxkhrtikrkipwmwyftpbkosuffbiaqszckoiczfedjvdhqduhfynkpysthmwqrvnlwnicxdbaafuhdyxvicgkqqmpykoiwxkyroycktuxomfhkicclciszkpofnvewmrqfgtalwtcnksfcwrzgozhaaccnqgkwxptnlubeybpnxyrqnapudnnnxojrgasxkmymmojtdvlfcavhnerbijtffgthxdmlbrirrpmqfngekwpnhzzvjqmudesqepisohdzzvqzampnqejfbihpzqnxflmdcojxsliivcqalzddepksplkflublbgwjneyrvwczbmqtvlyuxawbazrlnjscdurdvrrgfvwkurzuvgxqbcawjprpgzlvjzyizduhmqwnbkyxbmalpoajtdhpscdixvpaxxthafgxmkfukcwvwologzauvkpvapdjsmudxudveojqxlehdfrccijhykhbjjnhadvztauvpefylktpfubrklafasaucmjsrwfmqkruixoxrnnhqrchabijmcwqdmmgenakkgffyzheyojrbdctyzjbtmsssiuoagyrubxijtaoxzssnlpaeygpvpdxtkhneebjloeclihizesmtufeosgyqknjqbuqjhfownrwqqiqmoafokxhbxmlvzpkxvuowohugjijhkqpovxcxcuwdkyxnceklgczfcmifjrgmdlptfnamznqhwhhvtiuzyrxqbudwibxkphpiliojnlbeeieophdkmzblafwahmmjnabrmzgbjxaikpltyljlgrshnyogvaxjeoguikfxfskvfnbkrhwhxtdnlngdryjmitcamfyewdfrlaksbuvogguygkmxxzkggkkferebqjxtrtxghdfxknjlsucfsrrrvkuetnwnnhcvumykmbogmyqaxgblvtccrmdzavmjctxiqrmpmbbjepbacxggokxruhqxgnnzjdspngyhgplszmuavzurbecszuowcwqbznjxyihavihtanqaxonintcmodrowzazmnblknwfndlkajnivjitmugmjiuntjngwjufycaueptblbuqehoybqxtiifadctizixenqbrksvfloyujogznshgzxddkxprbgaqpickfkyxrzwthwwfqcoxearjivdgaxixkajsoainkmuyjrniugsbssmuowmodqnvlvksopttulpyhkxihllxfhgcoyjkmlqnmmaealsrczaquqirzicfdpywwxuobmczvebzljtqrqaaxdnqovptsswxzptegjfjjyhyvuesitickrehnfgepaavahqgnkhabclnoronflnonoqzrbkopniagogdjyiqlmshodrrzhndx";

            System.out.println("TEST STRING: " + test);
            System.out.println("TEST LEN: " + len);
            long t1 = System.currentTimeMillis();
            String valeria = solverValeria(test);
            long t2 = System.currentTimeMillis();
            String anyone = solverAnyone(test);
            System.out.println("TIME: " + (t2 - t1) + " mileseconds");
            System.out.printf("\nVALERIA: %s \n %s", valeria.length(), valeria);
            System.out.printf("\nANYONE: %s \n %s", anyone.length(), anyone);
            if (t2 - t1 >= 1000) {
                System.out.println("ERROR\n");
                break;
            } else {
                System.out.println("SUCCESS\n");
            }
        }
    }

    public static String solverValeria(String word) {
        int n = word.length();
        int[][] lps_table = new int[n][n];
        for (int i = 0; i < n; i++) {
            lps_table[i][i] = 1;
        }

        for (int word_size = 2; word_size <= n; word_size++) {
            for (int start_index = 0; start_index <= n - word_size; start_index++) {
                int end_index = start_index + word_size - 1;
                if (word.charAt(start_index) == word.charAt(end_index)) {
                    lps_table[start_index][end_index] = lps_table[start_index + 1][end_index - 1] + 2;
                } else {
                    lps_table[start_index][end_index] = Math.max(
                            lps_table[start_index + 1][end_index],
                            lps_table[start_index][end_index - 1]
                    );
                }
            }
        }

        int length = lps_table[0][n - 1];
        int start_index = 0;
        int end_index = n - 1;
        StringBuilder result = new StringBuilder();

        while (start_index <= end_index) {
            if (word.charAt(start_index) == word.charAt(end_index)) {
                result.append(word.charAt(start_index));
                start_index++;
                end_index--;
            } else if (lps_table[start_index + 1][end_index] > lps_table[start_index][end_index - 1]) {
                start_index++;
            } else {
                end_index--;
            }
        }

        if (length % 2 != 0) {
            char ch = result.charAt(result.length() - 1);
            String one = result.deleteCharAt(result.length() - 1).toString();
            String two = result.reverse().toString();
            result = new StringBuilder().append(one).append(ch).append(two);
        } else {
            result.append(result.reverse());
        }
        return result.toString();
    }

    public static String solverAnyone(String str) {
        int n = str.length();

        if (n == 1) {
            return str;
        }

        if (n == 2) {
            if (str.charAt(0) == str.charAt(1)) {
                return str;
            } else {
                return str.charAt(0) + "";
            }
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = str.charAt(i - 1) == str.charAt(i) ? 2 : 1;
        }

        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 2; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        ArrayList<Character> palyndrom = new ArrayList<>();
        int i = 1;
        int j = n;
        boolean duplicateMiddleLetter = true;

        while (i <= n && j >= 1) {

            if (i == n) {
                palyndrom.add(str.charAt(j - 1));
                duplicateMiddleLetter = false;
                break;
            }

            if (dp[i][j] == 0) {
                break;
            }

            if (dp[i + 1][j] == dp[i][j]) {
                i++;
            } else if (dp[i][j - 1] == dp[i][j]) {
                j--;
            } else if (dp[i][j] == dp[i + 1][j - 1] + 2) {
                palyndrom.add(str.charAt(j - 1));
                i++;
                j--;
            } else {
                palyndrom.add(str.charAt(j - 1));
                duplicateMiddleLetter = false;
                break;
            }
        }
        LinkedList<Character> result = new LinkedList<>(palyndrom);
        int diff = duplicateMiddleLetter ? 0 : 1;
        for (int k = palyndrom.size() - 1 - diff; k >= 0; k--) {
            result.add(palyndrom.get(k));
        }
        StringBuilder builder = new StringBuilder();
        result.forEach(builder::append);
        return builder.toString();
    }
}
