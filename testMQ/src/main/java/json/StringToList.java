package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: liuhui19
 * @Date: 2019/9/11 17:50
 * @Description:
 */
public class StringToList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("您","无人","暂时"));
        System.out.println(String.join("", list));
    }


}