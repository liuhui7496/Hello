package json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //1。通过对象生成JSON串，对象里包含对象数组转成JSON串。
        Person person = new Person();
        person.setUsername("zhangsan");
        person.setEmail("qq@qq.com");
        person.setSex("m");
        person.setAge(17);

        Card card1 = new Card();
        card1.setCardName("bankCard1");
        card1.setCardCode("8888888");
        card1.setCardValue(999999);

        Card card2 = new Card();
        card2.setCardName("bankCard1");
        card2.setCardCode("9999999");
        card2.setCardValue(8888888);

        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        person.setCardList(cards);

        String json = JSON.toJSON(person).toString();

        System.out.println(json);
    }
}
