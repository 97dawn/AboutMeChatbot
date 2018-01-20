package aboutmechatbot.data;

import java.util.HashMap;

/**
 * @version 1.0
 * @author Doeun Kim
 */
public class Data {
    
    private HashMap<String, String[]> celebrities;
    
    public Data(){
         celebrities = new HashMap<>();
         //  name, image, job,birth, height,weight,(6)youtube, (7)instagram, (8)twitter
         String[] MinhoLee = {"Minho Lee",
         "file:images/MinhoLee.jpg",
         "Actor","1987.6.22","187cm","71kg","https://www.youtube.com/results?search_query=%EC%9D%B4%EB%AF%BC%ED%98%B8", "https://www.instagram.com/Actorleeminho/",null};
         String[] JihyunJeon = {"Jihyun Jeon",
         "file:images/JihyunJeon.jpg",
         "Actress","1981.10.30","173.5cm", "52kg","https://www.youtube.com/results?search_query=%EC%A0%84%EC%A7%80%ED%98%84", null, null};
         String[] Jisung = {"Taegeun Kwak",
         "file:images/Jisung.jpg",
         "Actor","1977.2.27","178cm", "70kg","https://www.youtube.com/results?search_query=%EC%A7%80%EC%84%B1","https://www.instagram.com/justin_jisung/",null};
         String[] BoyoungLee = {"Boyoung Lee",
         "file:images/BoyoungLee.jpg",
         "Actress","1979.1.12","168cm",null,"https://www.youtube.com/results?search_query=%EC%9D%B4%EB%B3%B4%EC%98%81",null,null};
         String[] Zico = {"Jiho Woo",
         "file:images/JihoWoo.jpg",
         "Rapper in BlockB","1992.9.14", "182cm", "65kg","https://www.youtube.com/results?search_query=%EC%A7%80%EC%BD%94" ,"https://www.instagram.com/woozico0914/","https://twitter.com/ZICO92"};
         String[] GD = {"Jiyong Kwon",
         "file:images/JiyongKwon.jpg",
         "Rapper and Singer in BigBang","1988.8.18","177cm", "58kg","https://www.youtube.com/results?search_query=%EA%B6%8C%EC%A7%80%EC%9A%A9","https://www.instagram.com/xxxibgdrgn/","https://twitter.com/ibgdrgn"};
         String[] Sunmi = {"Sunmi Lee", 
         "file:images/SunmiLee.jpg",
         "Singer","1992.5.2","166cm","43kg","https://www.youtube.com/results?search_query=%EC%84%A0%EB%AF%B8","https://www.instagram.com/miyayeah/","https://twitter.com/official_sunmi_"};
         String[] Taeyeon = {"Taeyeon Kim",
         "file:images/TaeyeonKim.jpg",
         "Singer in SNSD","1989.3.9",null, null, "https://www.youtube.com/results?search_query=%ED%83%9C%EC%97%B0", "https://www.instagram.com/Taeyeon_ss/",null};
         String[] YonghwaJung = {"Yonghwa Jung",
         "file:images/YonghwaJung.jpg",
         "Singer in CNBlue","1989. 6.22","180cm", "63kg", "https://www.youtube.com/results?search_query=%EC%A0%95%EC%9A%A9%ED%99%94","https://www.instagram.com/jyheffect0622/","https://twitter.com/JYHeffect"};
         String[] DujunYoon = {"Dujun Yoon",
         "file:images/DujunYoon.jpg",
         "Sing in Highlight","1989.7.4", "178cm", "66kg", "https://www.youtube.com/results?search_query=%EC%9C%A4%EB%91%90%EC%A4%80", "https://www.instagram.com/beeeestdjdjdj/","https://twitter.com/BeeeestDJ"};
         celebrities.put("Minho Lee", MinhoLee);
         celebrities.put("Jihyun Jeon", JihyunJeon);
         celebrities.put("Taegeun Kwak", Jisung);
         celebrities.put("Boyoung Lee", BoyoungLee);
         celebrities.put("Jiho Woo", Zico);
         celebrities.put("Jiyong Kwon", GD);
         celebrities.put("Sunmi Lee", Sunmi);
         celebrities.put("Taeyeon Kim", Taeyeon);
         celebrities.put("Yonghwa Jung", YonghwaJung);
         celebrities.put("Dujun Yoon", DujunYoon);
    }
    
    public HashMap<String, String[]> getCelebritiesData(){
        return celebrities;
    }
}
