package aboutmechatbot;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Doeun Kim
 */
public class Data {
    
    private HashMap<String, String[]> celebrities;
    
    public Data(){
         celebrities = new HashMap<>();
         //  name, image, job,birth, height,weight,youtube, instagram, twitter
         String[] MinhoLee = {"Minho Lee",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201605%2F20160517121435641-157383.jpg",
         "Actor","1987.6.22","187cm","71kg","https://www.youtube.com/results?search_query=%EC%9D%B4%EB%AF%BC%ED%98%B8", "https://www.instagram.com/Actorleeminho/",null};
         String[] JihyunJeon = {"Jihyun Jeon",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F125%2F201212262021589401.jpg",
         "Actress","1981.10.30","173.5cm", "52kg","https://www.youtube.com/results?search_query=%EC%A0%84%EC%A7%80%ED%98%84", null, null};
         String[] Jisung = {"Taegeun Kwak",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F5%2F201308061746201891.jpg",
         "Actor","1977.2.27","178cm", "70kg","https://www.youtube.com/results?search_query=%EC%A7%80%EC%84%B1","https://www.instagram.com/justin_jisung/",null};
         String[] BoyoungLee = {"Boyoung Lee",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201702%2F20170203185134627-750608.jpg",
         "Actress","1979.1.12","168cm",null,"https://www.youtube.com/results?search_query=%EC%9D%B4%EB%B3%B4%EC%98%81",null,null};
         String[] Zico = {"Jiho Woo",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201801%2F20180108113919887.jpg",
         "Rapper in BlockB","1992.9.14", "182cm", "65kg","https://www.youtube.com/results?search_query=%EC%A7%80%EC%BD%94" ,"https://www.instagram.com/woozico0914/","https://twitter.com/ZICO92"};
         String[] GD = {"Jiyong Kwon",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F5%2F201612152122408071.jpg",
         "Rapper and Singer in BigBang","1988.8.18","177cm", "58kg","https://www.youtube.com/results?search_query=%EA%B6%8C%EC%A7%80%EC%9A%A9","https://www.instagram.com/xxxibgdrgn/","https://twitter.com/ibgdrgn"};
         String[] Sunmi = {"Sunmi Lee", 
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201708%2F20170829182154429.jpg",
         "Singer","1992.5.2","166cm","43kg","https://www.youtube.com/results?search_query=%EC%84%A0%EB%AF%B8","https://www.instagram.com/miyayeah/","https://twitter.com/official_sunmi_"};
         String[] Taeyeon = {"Taeyeon Kim",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F188%2F201712121421546321.jpg",
         "Singer in SNSD","1989.3.9",null, null, "https://www.youtube.com/results?search_query=%ED%83%9C%EC%97%B0", "https://www.instagram.com/Taeyeon_ss/",null};
         String[] YonghwaJung = {"Yonghwa Jung",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F160%2F201707131222492181.jpg",
         "Singer in CNBlue","1989. 6.22","180cm", "63kg", "https://www.youtube.com/results?search_query=%EC%A0%95%EC%9A%A9%ED%99%94","https://www.instagram.com/jyheffect0622/","https://twitter.com/JYHeffect"};
         String[] DujunYoon = {"Dujun Yoon",
         "https://search.pstatic.net/common?type=a&size=120x150&quality=95&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201710%2F2017101318251678.jpg",
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
