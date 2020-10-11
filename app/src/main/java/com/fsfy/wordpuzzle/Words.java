package com.fsfy.wordpuzzle;

import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fsfy.wordpuzzle.Database.ItemArray;

import java.util.ArrayList;
import java.util.List;

public class Words {
    // Nesneler, Sıfatlar, MeyveSebze, Fiiller, Aileiliski, Meslekler, Yerler, Renkler, Hayvanlar, Vucut, Zaman

    private static String[] wordArraysName;
    public static String[] getWordArraysName() {
        if (wordArraysName == null) {
            wordArraysName = new String[11];

            wordArraysName[0] = "Nesneler";
            wordArraysName[1] = "Sıfatlar";
            wordArraysName[2] = "MeyveSebze";
            wordArraysName[3] = "Fiiller";
            wordArraysName[4] = "Aileiliski";
            wordArraysName[5] = "Meslekler";
            wordArraysName[6] = "Yerler";
            wordArraysName[7] = "Renkler";
            wordArraysName[8] = "Hayvanlar";
            wordArraysName[9] = "Vucut";
            wordArraysName[10] = "Zaman";
        }

        return wordArraysName;
    }

    private static List<String[][]> listWordArrays;
    public static List<String[][]> getListWordArrays() {
        if (listWordArrays == null) {
            listWordArrays = new ArrayList<>();

            listWordArrays.add(Nesneler);
            listWordArrays.add(Sifatlar);
            listWordArrays.add(Fruit);
            listWordArrays.add(Fiiller);
            listWordArrays.add(Aileiliski);
            listWordArrays.add(Meslekler);
            listWordArrays.add(Yerler);
            listWordArrays.add(Renkler);
            listWordArrays.add(Hayvanlar);
            listWordArrays.add(Vucut);
            listWordArrays.add(Zaman);
        }
        return listWordArrays;
    }

    public static String[][] Nesneler = {
            // NESNELER
            {"takvim", "calendar"},
            {"saat", "clock"},
            {"sözlük", "dictionary"},
            {"silgi", "eraser"},
            {"kağıt", "paper"},
            {"sandalye", "chair"},
            {"mobilya", "furniture"},
            {"yol", "way"},
            {"yaşam", "life"},
            {"devlet", "state"},
            {"yer", "place"},
            {"durum", "case"},
            {"hükümet", "government"},
            {"alan", "area"},
            {"olay", "fact"},
            {"ay", "month"},
            {"iş", "business"},
            {"üye", "member"},
            {"kanun", "law"},
            {"topluluk", "community"},
            {"başkan", "president"},
            {"fikir", "idea"},
            {"savaş", "war"},
            {"barış", "peace"},
            {"sebep", "reason"},
            {"araştırma", "research"},
            {"mutfak", "kitchen"},
            {"yatak odası", "bedroom"},
            {"oturma odası", "living room"},
            {"yemek odası", "dining room"},
            {"çamaşır odası", "utility room"},
            {"banyo", "bathroom"},
            {"bodrum kat", "basement"},
            {"asansör", "elevator"},
            {"merdiven", "stairs"},
            {"kiler", "cellar"},
            {"çatı katı", "attic"},
            {"salon", "sitting Room"},
            {"tuvalet", "toilets"},
    };

    public static String[][] Sifatlar = {
            // SIFATLAR
            {"en kötü", "worst"},
            {"çirkin", "ugly"},
            {"fakir", "poor"},
            {"zengin", "rich"},
            {"genç", "young"},
            {"yaşlı", "old"},
            {"zeki", "clever"},
            {"aptal", "stupid"},
            {"farklı", "different"},
            {"aynı", "same"},
            {"hafif", "light"},
            {"ağır", "heavy"},
            {"eğlenceli", "funny"},
            {"sıkıcı", "boring"},
            {"erken", "early"},
            {"geç", "late"},
            {"cesur", "brave"},
            {"tehlikeli", "dangerous"},
            {"zor", "difficult"},
            {"lezzetli", "delicious"},
            {"taze", "fresh"},
            {"kirli", "dirty"},
            {"yarım", "half"},
            {"aç", "hungry"},
            {"kızgın", "angry"},
            {"hasta", "ill"},
            {"sağlıklı", "healthy"},
            {"imkansız", "impossible"},
            {"kıskanç", "jealous"},
            {"kibar", "polite"},
            {"önceki", "previous"},
            {"yanlış", "wrong"},
    };

    public static String[][] Fruit = {
            // MEYVE - SEBZE
            {"portakal", "orange"},
            {"karpuz", "watermelon"},
            {"ananas", "pineapple"},
            {"üzüm", "grape"},
            {"lahana", "cabbage"},
            {"armut", "pear"},
            {"şeftali", "peach"},
            {"yaban mersini", "blueberries"},
            {"domates", "tomato"},
            {"patates", "potato"},
            {"salatalık", "cucumber"},
            {"kuru soğan", "onion"},
            {"yeşil biber", "green pepper"},
            {"çilek", "strawberry"},
            {"marul", "lettuce"},
            {"mantar", "mushroom"},
            {"limon", "lemon"},
            {"turp", "radish"},
            {"yeşil fasulye", "green beans"},
            {"fasulye", "beans"},
            {"havuç", "carrot"},
            {"bal kabağı", "pumpkin"},
            {"ıspanak", "spinach"},
            {"greyfurt", "grapefruit"},
            {"brokoli", "broccoli"},
            {"kiraz", "cherry"},
            {"zeytin", "olive"},
            {"mısır", "corn"},
            {"biber", "pepper"},
            {"erik", "plum"},
            {"kavun", "melon"},
            {"ahududu", "raspberry"},
            {"sarımsak", "garlic"},
            {"patlıcan", "eggplant"},
            {"bitki", "plant"},
            {"yeşil soğan", "scallion"},
            {"şalgam", "turnip"},
            {"bezelye", "pea"},
            {"kayısı", "apricot"},
            {"nar", "pomegranate"},
            {"hindistan cevizi", "coconut"},
            {"pancar", "beet"},
            {"zencefil", "ginger"}
    };

    public static String[][] Fiiller = {
            // FİİLLER
            {"olmak", "be"},
            {"sahip olmak", "have"},
            {"yapmak", "do"},
            {"almak", "get"},
            {"yapmak", "make"},
            {"düşünmek", "think"},
            {"almak", "take"},
            {"görmek", "see"},
            {"bulmak", "find"},
            {"vermek", "give"},
            {"anlatmak", "tell"},
            {"çalışmak", "work"},
            {"ihtiyaç duymak", "need"},
            {"hissetmek", "feel"},
            {"koymak", "put"},
            {"başlamak", "begin"},
            {"duymak", "hear"},
            {"yaşamak", "live"},
            {"inanmak", "believe"},
            {"getirmek", "bring"},
            {"olmak", "happen"},
            {"ayakta durmak", "stand"},
            {"kaybetmek", "lose"},
            {"buluşmak", "meet"},
            {"dahil etmek", "include"},
            {"devam etmek", "continue"},
            {"öğrenmek", "learn"},
            {"harcamak", "spend"},
            {"büyümek", "grow"},
            {"öğretmek", "teach"},
            {"teklif etmek", "offer"},
            {"hatırlamak", "remember"},
            {"ölmek", "die"},
            {"ulaşmak", "reach"},
            {"yükseltmek", "raise"},
            {"karar vermek", "decide"},
            {"açıklamak", "explain"},
            {"umut etmek", "hope"},
            {"taşımak", "carry"},
            {"vurmak", "hit"},
            {"anlaşmak", "agree"},
            {"katılmak", "join"},
            {"üretmek", "produce"},
            {"çizmek", "draw"},
            {"seçmek", "choose"},
            {"tutmak", "hold"},
            {"kontrol etmek", "check"},
            {"onaylamak", "confirm"},
            {"dilemek", "wish"},
            {"yıkamak", "wash"},
            {"giymek", "wear"},

            {"kabul etmek", "accept"},
            {"izin vermek", "allow"},
            {"ödünç almak", "borrow"},
            {"şikayet etmek", "complain"},
            {"düşmek", "fall"},
            {"doldurmak", "fill"},
            {"tamir etmek", "fix"},
            {"unutmak", "forget"},
            {"incitmek", "hurt"},
            {"dinlemek", "listen"},
            {"ödemek", "pay"},
            {"cevap vermek", "reply"},
            {"imzalamak", "sign"},
            {"hecelemek", "spell"},
            {"çalışmak", "study"},
            {"başarmak", "succeed"},
            {"denemek", "try"},
            {"endişelenmek", "worry"},
            {"değiştirmek", "change"},
            {"tutmak", "keep"},
            {"ayarlamak", "set"},
            {"kalkmak", "stay"}
    };


    public static String[][] Aileiliski = {
            {"çocuk", "child"},
            {"çocuklar", "children"},
            {"akrabalar", "relatives"},
            {"erkek nişanlı", "fiance"},
            {"kız nişanlı", "fiancee"},
            {"iş arkadaşı", "colleague"},
            {"torun", "grandchild"},
            {"anneanne babaanne", "grandmother"},
            {"torun", "grandson"},
            {"koca", "husband"},
            {"karı eş", "wife"},
            {"teyze hala", "aunt"},
            {"amca dayı", "uncle"},
            {"kuzen", "cousin"},
            {"komşu", "neighbor"},
            {"yeğen", "nephew"},
            {"anne baba", "parents"},
            {"boşanmış", "divorced"},
            {"nişanlı", "engaged"},
            {"evli", "married"},
            {"ayrılmış", "separated"},
            {"evlenmemiş", "unmarried"},
            {"dul", "widowed"}
    };

    public static String[][] Meslekler = {
            {"yazar", "author"},
            {"sanatçı", "artist"},
            {"berber", "barber"},
            {"marangoz", "carpenter"},
            {"genel müdür", "CEO"},
            {"aşçı", "cook"},
            {"dansçı", "dancer"},
            {"dişçi", "dentist"},
            {"mühendis", "engineer"},
            {"itfaiyeci", "fireman"},
            {"bahçıvan", "gardener"},
            {"ev kadını", "housewife"},
            {"hakim", "judge"},
            {"avukat", "lawyer"},
            {"yönetici", "manager"},
            {"müzisyen", "musician"},
            {"hemşire", "nurse"},
            {"profesör", "professor"},
            {"sekreter", "secretary"},
            {"şarkıcı", "singer"},
            {"asker", "soldier"},
            {"erkek garson", "waiter"},
            {"kadın garson", "waitress"},
            {"yazar", "writer"},
            {"muhasebeci", "accountant"},
            {"mimar", "architect"},
            {"reklamcı", "advertiser"},
            {"avukat", "attorney"},
            {"astronot", "astronaut"},
            {"esnaf", "artisan"},
            {"sporcu", "athlete"},
            {"çiftçi", "farmer"},
            {"temizlikçi", "cleaner"},
            {"bakıcı", "caretaker"},
            {"antrenör", "coach"},
            {"palyaço", "clown"},
            {"kurye", "courier"},
            {"dalgıç", "diver"},
            {"çiçekçi", "florist"},
            {"balıkçı", "fisher"},
            {"kurucu", "founder"},
            {"manav", "greengrocer"},
            {"stajyer", "intern"},
            {"gazeteci", "journalist"},
            {"gardiyan", "guard"},
            {"memur", "officer"},
            {"hırsız", "thief"},
            {"bilim adamı", "scientist"},
            {"büyücü", "wizard"},
            {"savaşçı", "warrior"},
            {"işçi", "worker"},
    };

    public static String[][] Yerler = {
            {"fırın", "bakery"},
            {"müze", "museum"},
            {"kilise", "church"},
            {"bakkal", "grocer"},
            {"cami", "mosque"},
            {"alışveriş merkezi", "mall"},
            {"kasap", "butcher"},
            {"eczane", "pharmacy"},
            {"göl", "lake"},
            {"nehir", "river"},
            {"deniz", "sea"},
            {"dağ", "mountain"},
    };

    public static String[][] Renkler = {
            {"pembe", "pink"},
            {"mor", "purple"},
            {"kahverengi", "brown"},
            {"turuncu", "orange"},
            {"gri", "grey"},
            {"lacivert", "navy"},
            {"bordo", "maroon"}
    };

    public static String[][] Hayvanlar = {
            {"koyun", "sheep"},
            {"keçi", "goat"},
            {"timsah", "crocodile"},
            {"kutup ayısı", "polar bear"},
            {"inek", "cow"},
            {"fil", "elephant"},
            {"zürafa", "giraffe"},
            {"kaz", "goose"},
            {"horoz", "cock"},
            {"gergedan", "rhino"},
            {"geyik", "deer"},
            {"goril", "gorilla"},
            {"kanguru", "kangaroo"},
            {"yunus balığı", "dolphin"},
            {"sıçan", "rat"},
            {"yarasa", "bat"},
            {"kertenkele", "lizard"},
            {"antilop", "antelope"},
            {"çita", "cheetah"},
            {"bukalemun", "chameleon"},
            {"boğa", "bull"},
            {"sincap", "squirrel"},
            {"öküz", "ox"},
            {"balina", "whale"},
            {"kaplumbağa", "turtle"},
            {"tavşan", "rabbit"},
            {"kurbağa", "frog"},
            {"arı", "bee"}
    };


    public static String[][] Vucut = {
            {"saç", "hair"},
            {"kafa", "head"},
            {"kulak", "ear"},
            {"burun", "nose"},
            {"ağız", "mouth"},
            {"diş", "tooth"},
            {"dişler", "teeth"},
            {"el", "hand"},
            {"parmak", "finger"},
            {"yanak", "cheek"},
            {"kol", "arm"},
            {"bacak", "leg"},
            {"diz", "knee"},
            {"ayak", "foot"},
            {"ayaklar", "feet"},
            {"kalça", "hip"},
            {"sakal", "beard"},
            {"göğüs", "breast"},
            {"çene", "chin"},
            {"dudak", "lip"},
            {"bıyık", "whiskers"},
            {"tırnak", "nail"},
            {"boyun", "neck"},
            {"omuz", "shoulder"},
            {"dil", "tongue"}
    };


    public static String[][] Zaman = {
            {"ocak", "january"},
            {"şubat", "february"},
            {"mart", "march"},
            {"nisan", "april"},
            {"mayıs", "may"},
            {"haziran", "june"},
            {"temmuz", "july"},
            {"ağustos", "august"},
            {"eylül", "september"},
            {"ekim", "october"},
            {"kasım", "november"},
            {"aralık", "december"},
            {"pazartesi", "monday"},
            {"salı", "tuesday"},
            {"çarşamba", "wednesday"},
            {"perşembe", "thursday"},
            {"cuma", "friday"},
            {"cumartesi", "saturday"},
            {"pazar", "sunday"},
            {"ilkbahar", "spring"},
            {"yaz", "summer"},
            {"sonbahar", "autumn"},
            {"kış", "winter"}
    };


//    public static String[][] Number = {
//            // SAYILAR
//            {"11", "eleven"},
//            {"12", "twelve"},
//            {"13", "thirteen"},
//            {"14", "fourteen"},
//            {"15", "fifteen"},
//            {"16", "sixteen"},
//            {"17", "seventeen"},
//            {"18", "eighteen"},
//            {"19", "ninteen"},
//            {"20", "twenty"},
//            {"21", "twenty-one"},
//            {"22", "twenty-two"},
//            {"23", "twent-three"},
//            {"30", "thirty"},
//            {"40", "forty"},
//            {"50", "fifty"},
//            {"60", "sixty"},
//            {"70", "seventy"},
//            {"80", "eighty"},
//            {"90", "ninety"},
//            {"100", "one hundred"},
//            {"101", "one hundred and one"},
//            {"102", "one hundred and two"},
//            {"200", "two hundred"},
//            {"340", "three hundred and forty"},
//            {"360", "three hundred and sixty"},
//            {"1,000", "one thousand"},
//            {"10,000", "ten thousand"},
//            {"10,563", "ten thousand, five hundred and sixty-three"},
//            {"100,000", "one hundred thousand"},
//            {"1,000,000", "one million"},
//            {"1,000,000,000", "one billion"},
//            {"1st", "first"},
//            {"2nd", "second"},
//            {"3rd", "third"},
//            {"4th", "fourth"},
//            {"5th", "fifth"},
//            {"6th", "sixth"},
//            {"7th", "seventh"},
//            {"8th", "eighth"},
//            {"9th", "ninth"},
//            {"10th", "tenth"},
//            {"11th", "eleventh"},
//            {"12th", "twelfth"},
//            {"13th", "thirteenth"},
//            {"14th", "fourteenth"},
//            {"15th", "fifteenth"},
//            {"16th", "sixteenth"},
//            {"17th", "seventeenth"},
//            {"18th", "eighteenth"},
//            {"19th", "nineteenth"},
//            {"20th", "twentieth"},
//            {"21st", "twenty-first"},
//            {"30th", "thirtieth"},
//            {"40th", "fourtieth"},
//            {"50th", "fiftieth"},
//            {"60th", "sixtieth"},
//            {"70th", "seventieth"},
//            {"80th", "eightieth"},
//            {"90th", "nintieth"},
//            {"100th", "one hundredth"},
//            {"101st", "one hundred-first"},
//            {"1,000th", "one thousandth"}
//    };
}