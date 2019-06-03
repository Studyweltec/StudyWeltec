package navdrawer.test.com.navigationdrawertest.others;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> home = new ArrayList<String>();

        List<String> student_speak_out = new ArrayList<String>();
        List<String> campuses = new ArrayList<String>();
        campuses.add("PETONE");
        campuses.add("AUCKLAND");
        campuses.add("PORIRUA");


        List<String> enquiry = new ArrayList<String>();
        List<String> location = new ArrayList<String>();
        List<String> about = new ArrayList<String>();
        List<String> info = new ArrayList<String>();
        List<String> exit = new ArrayList<String>();


        expandableListDetail.put("Home", home);
        expandableListDetail.put("Campuses", campuses);
        expandableListDetail.put("Student Speak Out", student_speak_out);
        expandableListDetail.put("Enquiry", enquiry);
        expandableListDetail.put("Location", location);
        expandableListDetail.put("About Us", about);
        expandableListDetail.put("Info", info);
        expandableListDetail.put("Exit", exit);

        return expandableListDetail;
    }
}
