package com.example.jizp.domreadfromxml;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.EventListener;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {

    private Button btnSave = null;
    private Button btnRead = null;
    private File file = null;

    private static final String FILENAME = "book.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.save);
        btnRead = (Button) findViewById(R.id.read);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentBuilder documentBuilder = null;
                Document document = null;
                Transformer transformer = null;

                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(getApplicationContext(), "读取失败，SD存储卡不存在！", Toast.LENGTH_LONG).show();
                    return;
                }

                String path = Environment.getExternalStorageDirectory().toString() + File.separator + "kkk" + File.separator + FILENAME;
                file = new File(path);

                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                try {
                    documentBuilder = factory.newDocumentBuilder();

                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                document = documentBuilder.newDocument();

                //建立节点
                Element books = document.createElement("books");
                Element book = document.createElement("book");
                Element bookname = document.createElement("bookname");
                Element author = document.createElement("author");
                Element publisher = document.createElement("publisher");

                //添加内容
                bookname.appendChild(document.createTextNode("跟我学Android"));
                author.appendChild(document.createTextNode("蒋老夫子"));
                publisher.appendChild(document.createTextNode("人民邮电出版社"));

                book.appendChild(bookname);
                book.appendChild(author);
                book.appendChild(publisher);

                books.appendChild(book);

                document.appendChild(book);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();

                try {
                    transformer = transformerFactory.newTransformer();

                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                }

                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);

                try {
                    transformer.transform(source, result);
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
            }
        });


        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentBuilder documentBuilder = null;
                Document document = null;
                StringBuffer info = null;

                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(getApplicationContext(), "读取失败，SD存储卡不存在！", Toast.LENGTH_LONG).show();
                    return;
                }

                String path = Environment.getExternalStorageDirectory().toString()
                        + File.separator
                        + "kkk"
                        + File.separator
                        + FILENAME;

                file = new File(path);

                if (!file.exists()) {
                    Toast.makeText(getApplicationContext(), "文件不存在！", Toast.LENGTH_LONG).show();
                    return;
                }

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                try {
                    documentBuilder = factory.newDocumentBuilder();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

                try {
                    document = documentBuilder.parse(file);
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                NodeList nodeList = document.getElementsByTagName("book");

                info = new StringBuffer();

                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    info.append(info + element.getElementsByTagName("bookname").item(0).getFirstChild().getNodeValue()).append("★★★");
                    info.append(info + element.getElementsByTagName("author").item(0).getFirstChild().getNodeValue()).append("★★★");
                    info.append(info + element.getElementsByTagName("publisher").item(0).getFirstChild().getNodeValue()).append("★★★");
                }

                Toast.makeText(getApplicationContext(), info.toString(), Toast.LENGTH_LONG).show();


            }
        });
    }
}
