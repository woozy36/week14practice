import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("JSON with gson example");
        serializeSimple();
        deserializeSimple();

    }

    static void serializeSimple() {
        Todos losdias = new Todos("walk the dog", false, 0, 3, "dog");
        Todos losmamas = new Todos("Pay the bills", false, 1, 1, "bills");
        ArrayList<Todos> todosList = new ArrayList<>();
        todosList.add(losdias);
        todosList.add(losmamas);


        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("data.json")) {

            gson.toJson(todosList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void deserializeSimple() {
        try (FileReader reader = new FileReader("data.json")) {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            Gson gson = new Gson();
            ArrayList<Todos> losdias = gson.fromJson(jsonElement, ArrayList.class);
            System.out.println(losdias);
            System.out.println(losdias.get(0));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Simple {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;

    public Simple(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}

class Todos {
    private String body;
    private boolean isDone;
    private int id;
    private int priority;
    private String title;

    public Todos(String body, boolean isDone, int id, int priority, String title) {
        this.body = body;
        this.isDone = isDone;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "body='" + body + '\'' +
                ", isDone=" + isDone +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}