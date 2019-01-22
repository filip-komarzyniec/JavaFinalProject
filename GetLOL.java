package po.crawler.web.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class GetLOL {
// modifier to package private
    static ArrayList<String> characters = new ArrayList();
    static ArrayList<String> weapons = new ArrayList<>();
    static ArrayList<String> boots = new ArrayList<>();
    static ArrayList<String> championImg = new ArrayList<>();
    static HashMap<String, ArrayList<String>> items_attr = new HashMap<>();
    static HashMap<String, ArrayList<String>> boots_attr = new HashMap<>();
    static ArrayList<BufferedImage> championImgBuffered = new ArrayList<>();
    private static Document doc;

    final static String path = "https://www.leagueofgraphs.com";
    final static String pathPng = "/Users/filip/Documents/Pliki/AGH/III semestr/Programowanie Obiektowe/web_crawler/src/po/crawler/web/project/champions_png/";

// pobranie nazw bohaterów
    public static void character() throws IOException {
        final Document document = Jsoup.connect("https://www.leagueofgraphs.com/pl/champions/overview").get();
        //pętla zamieniająca elementy na stringi
        for (Element row : document.select("table.data_table tr td span.name")) {
            String title = row.text();
            characters.add(title);
        }
    }
// pobranie url obrazków bohaterów
    public static void images() {
        try {
            Document doc = Jsoup.connect("https://leagueofgraphs.com/champions/overview").get();
            Elements links = doc.body().select("table.data_table td a[href]");
            for (Element link : links) {
                Document doc_temp = Jsoup.connect(path + link.attr("href")).get();
                championImg.add("https:" + doc_temp.body().select("div.img >img[src]").attr("src"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// pobieram obrazki bohaterów z url i zapisuję do pakietu champions_png
    public static void buffImages() {
        try {
            for (int i = 0; i < GetLOL.characters.size()-1; i++) {
                ReadableByteChannel readChannel = Channels.newChannel(new URL(championImg.get(i)).openStream());
                FileOutputStream fileOS = new FileOutputStream(String.format(pathPng+"image%d.png", i));
                FileChannel writeChannel = fileOS.getChannel();
                writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
                fileOS.close(); readChannel.close();
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io");
            e.printStackTrace();
        }
    }
// pobieram bronie
    public static void weapon() throws IOException {
        final Document document = Jsoup.connect("https://www.leagueofgraphs.com/pl/champions/items").get();
        //pętla zamieniająca elementy na stringi
        for (Element row : document.select("div.box.box-padding-10:contains(Glabalne) table.data_table.sortable_table tr td img[alt]")) {
            String title = row.attr("alt");
            row.attr("alt");
            weapons.add(title);
        }
        // return weapons;
    }

// pobieram buty
    public static void boot() throws IOException {   //metoda wczytania danych z html
        final Document document = Jsoup.connect("https://www.leagueofgraphs.com/pl/champions/items").get();
        //pętla zamieniająca elementy na string
        for (Element row : document.select("div.box.box-padding-10:contains(Buty) table.data_table.sortable_table tr td img[alt]")) {
            String title = row.attr("alt");
            row.attr("alt");
            boots.add(title);
        }
    }

// pobieram przedmioty globalne
    public static void getGlobalItems() throws IOException {
        doc = Jsoup.connect("https://leagueofgraphs.com/pl/champions/overview").get();
        String items_link = path+doc.body().select("div#sidebar-container dd>a[href*=/items]").attr("href");
        doc = Jsoup.connect(items_link).get();
        Elements tmp = doc.body().select("h3:contains(Glabalne) + table.data_table.sortable_table td>img[src]");
        // pobieram zawartość skryptu do tooltipa
        Element scriptTag = doc.body().select("div#mainContent div.row + script").first();
        for(Element item: tmp) {
            Pattern p = Pattern.compile(item.attr("tooltip-var")+"(.*?)\\W{3,4}stats>");
            Matcher m = p.matcher(scriptTag.data());
            m.find();       // bo tylko jeden wynik i tak
            Pattern p2 = Pattern.compile("\\W(\\d+)\\W? ((\\w+\\s?)+)");  // grupa 1 to liczba, 2 to nazwa
            Matcher m2 = p2.matcher(m.group(1));
            items_attr.put(item.attr("alt"),new ArrayList<>()); // tworzę mapę z nową listą
            while (m2.find()){
                items_attr.get(item.attr("alt")).add(m2.group(1)+" "+m2.group(2));// dodaję do listy atrybutów
            }
        }
    }
// pobieram atrybuty butów
    public static void getBootsAttr() throws IOException {
        doc = Jsoup.connect("https://leagueofgraphs.com/pl/champions/overview").get();
        String items_link = path+doc.body().select("div#sidebar-container dd>a[href*=/items]").attr("href");
        doc = Jsoup.connect(items_link).get();
        Elements tmp = doc.body().select("h3:contains(Buty) + table.data_table.sortable_table td>img[src]");
        // pobieram zawartość skryptu tooltipa
        Element scriptTag = doc.body().select("div#mainContent div.row + script").first();
        for(Element item: tmp) {
            Pattern p = Pattern.compile(item.attr("tooltip-var")+"(.*?)\\W{3,4}stats>");
            Matcher m = p.matcher(scriptTag.data());
            m.find();       // bo tylko jeden wynik i tak
            Pattern p2 = Pattern.compile("\\W(\\d+)\\W? ((\\w+\\s?)+)");  // grupa 1 to liczba, 2 to nazwa
            Matcher m2 = p2.matcher(m.group(1));
            boots_attr.put(item.attr("alt"),new ArrayList<>()); // tworzę mapę z nową listą
            while (m2.find()){
                boots_attr.get(item.attr("alt")).add(m2.group(1)+" "+m2.group(2));// dodaję do listy atrybutów
            }
        }
    }
// metoda pobierająca wszystko potrzebne do programu
    public static void download() {
        try {
            character();
            images();
            buffImages();
            weapon();
            boot();
            getGlobalItems();
            getBootsAttr();
        }catch (IOException e){
            System.out.println("wywaliło w pobieranie w metodzie statycznej");
            e.printStackTrace();
        }
    }
}
