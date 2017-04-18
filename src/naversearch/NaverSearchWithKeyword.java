package naversearch;

import naversearch.service.NaverApiAgent;
import org.json.JSONObject;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class NaverSearchWithKeyword {
    public static void main(String[] args){
        String keyword = "커리";

        String json = NaverApiAgent.searchAndReturnJson(keyword);

        JSONObject obj = new JSONObject(json);

//        JSONArray list = obj.getJSONArray("items");
//        String theThirdLink = list.getJSONObject(2).getString("bloggerlink");

        String theThirdLink = obj.getJSONArray("items")
                .getJSONObject(2).getString("bloggerlink");

        System.out.println("블로그 링크 리스트: ");
        System.out.println(theThirdLink);

        int displayCount = (int)obj.get("display");

        System.out.println("블로그 제목 리스트: ");
        for(int i = 0; i < displayCount; i++){
            System.out.println(obj.getJSONArray("items")
                    .getJSONObject(i).getString("bloggername"));
        }
    }
}
