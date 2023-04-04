package App;

import Entities.Comment;
import Entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        /* FIRST POST */
        Post p1 = new Post(
                sdf.parse("04/10/2021 16:22:04"),
                "Starting drive lessons",
                "Can't wait to meet new people after pandemic!",
                12);

        Comment c1 = new Comment("Nice man! can't wait to see you driving");
        Comment c2 = new Comment("Finally something to get your out of that bedroom");

        p1.addComment(c1);
        p1.addComment(c2);


        /* SECOND POST */
        Post p2 = new Post(
                sdf.parse("05/10/2021 23:36:18"),
                "I met an awesome girl",
                "I think I fall in love at the first momment",
                13);

        Comment c3 = new Comment("Call her to hangout");
        Comment c4 = new Comment("Son, when are you going to introduce her to me?");

        p2.addComment(c3);
        p2.addComment(c4);


        /* PRINTS */
        System.out.println(p1);
        System.out.println(p2);


    }
}
