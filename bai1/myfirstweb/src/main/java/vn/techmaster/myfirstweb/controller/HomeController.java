package vn.techmaster.myfirstweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.myfirstweb.model.Book;
import vn.techmaster.myfirstweb.model.Message;
import vn.techmaster.myfirstweb.model.Student;



@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping(value="/hi",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String hello() {
        return "<h1>hello world</h1>";
    }
    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book getBook() {
        return new Book("de men phieu lu ky","to hoai","1945");
    }

    @GetMapping("/add/{a}/{b}")
    @ResponseBody
    public int add(@PathVariable("a") int a, @PathVariable("b") int b ) {
    return a + b;
    }
    @GetMapping("/name/{your_name}")
    @ResponseBody
    public String hi(@PathVariable("your_name") String yourName) {
    return "Hi " + yourName;
    }

    @PostMapping(value = "/message",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message echoMessage(@RequestBody Message message) {
        return message;
    }
    // bài 1
    private static String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static String digits = "0123456789";
    private static String randomString = alpha + alphaUpperCase + digits;
    private static Random generator = new Random();
    

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    

    @GetMapping("/random")
    @ResponseBody
    public String Random() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int number = randomNumber(0, randomString.length() - 1);
            char ch = randomString.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    // bài 2
    @GetMapping("/qoute")
    @ResponseBody
    public String Listquote() {
        int count = randomNumber(1,5);
        switch(count) {
            case 1:
              return "Kiến tha lâu đầy tổ";
            case 2:
              return "Có công mài sắt, có ngày nên kim";
            case 3:
              return "Không thầy đố mày làm nên";
            case 4:
              return "Học thầy không tày học bạn";
            default:
              return "Kiến tha lâu đầy tổ";
          }
    }

    // bài 3
    @PostMapping("/bmi")
    @ResponseBody
    public String bmi(@RequestParam int kg,@RequestParam int cm) {
        double chiSoBMI = kg / (cm*0.01 * cm*0.01);
            return "Chỉ số BMI là" + chiSoBMI;
        
    }

    // bài 4
    List<Student> students = new ArrayList<>();

    @GetMapping("/student")
    @ResponseBody
    public List<Student> students() {
        students.add(new Student("1", "Tuanson", "JV07"));
        return students;
    }

    @PostMapping("/student")
    @ResponseBody
    public List<Student> student(@RequestParam String id, @RequestParam String name,@RequestParam String classManager) {
        students.add(new Student(id, name, classManager));
        return students;
    }

    

}
