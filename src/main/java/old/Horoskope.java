package old;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 11.06.14
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
public class Horoskope {
    static String[] allSigns = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius",
            "Capricorn", "Aquarius", "Pisces"};
    static String[] allStories = {"Horoskop for Aries", "Horoskop for Taurus", "Horoskop for Gemini", "Horoskop for Cancer",
            "Horoskop for Leo", "Horoskop for Virgo", "Horoskop for Libra", "Horoskop for Scorpio", "Horoskop for Sagittarius",
            "Horoskop for Capricorn", "Horoskop for Aquarius", "Horoskop for Pisces"};
    static HashMap<String, String> signs = new HashMap<String, String>();

    public static void main(String[] args) {
        Horoskope horoskope = new Horoskope();
        for (int i = 0; i < allStories.length; i++) {
                horoskope.putHoroskop(signs, allSigns[i], allStories[i]);
         }

        horoskope.displayHoroskop(signs, "lasldasd");
    }

    public void putHoroskop(HashMap<String, String> dict, String sign, String horoStory) {
        dict.put(sign, horoStory);
    }

    public void displayHoroskop(HashMap<String, String> dict, String sign) {
        if (!dict.containsKey(sign)) {
            System.out.println("Sorry, there is no such sign!");
        }
        else {
            System.out.println(dict.get(sign));
        }
    }
}
