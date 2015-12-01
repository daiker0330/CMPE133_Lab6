/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Lab6.Student;
import Lab6.Teacher;
import Lab6.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author yunfan
 */
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if(request.getParameter("func").equals("search")){
                gotoSearch(out, request, response);
            }
            else if(request.getParameter("func").equals("login")){
                gotoLogin(out, request, response);
            }
            else if(request.getParameter("func").equals("enroll")){
                gotoEnroll(out, request, response);
            }
            else{
                String msg="No Page Found";  
                String title="Error";  
                gotoMsg(out, request, response,title,msg);
            }
        }
    }
    
    private static void addDoc(IndexWriter w, String Class, String number, String time) throws IOException 
	{
		  Document doc = new Document();
		  // A text field will be tokenized
		  doc.add(new TextField("Classes", Class, Field.Store.YES));
		  // We use a string field for isbn because we don\'t want it tokenized
		  doc.add(new StringField("Number", number, Field.Store.YES));
                  doc.add(new StringField("Time", time, Field.Store.YES));
		  w.addDocument(doc);
	}

    private void gotoSearch(PrintWriter out, HttpServletRequest request, HttpServletResponse response){
        try
        {
            //	Specify the analyzer for tokenizing text.
            //	The same analyzer should be used for indexing and searching
            StandardAnalyzer analyzer = new StandardAnalyzer();

            //	Code to create the index
            Directory index = new RAMDirectory();

            IndexWriterConfig config = new IndexWriterConfig(analyzer);

            IndexWriter w = new IndexWriter(index, config);
            addDoc(w, " Software Engineering 2", "133", "Mon.");
            addDoc(w, " Software Engineering 1", "CMPE 131:", "Mon.");
            addDoc(w, " Object Oriented Design", "CS 151:", "Mon.");
            addDoc(w, " Advance Data Structures with Java ", "CS 146:", "Mon.");
            addDoc(w, " System Security with Java", "CS 166:", "Mon.");
            addDoc(w, "Lucene demo by teja", "23k43413", "Mon.");
            w.close();

            //	Text to search
            String querystr = request.getParameter("keyword");

            //	The \"title\" arg specifies the default field to use when no field is explicitly specified in the query
            Query q = new QueryParser("Classes", analyzer).parse(querystr);

            // Searching code
            int hitsPerPage = 10;
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
            searcher.search(q, collector);
            ScoreDoc[] hits = collector.topDocs().scoreDocs;

            //	Code to display the results of search
            //out.println("Found " + hits.length + " Classes Matching your Requirement");
            List list = new ArrayList();
            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                Course course = new Course(d.get("Number"), d.get("Classes"), d.get("Time"));
                //out.println((i + 1) + ". " +  d.get("Number")+ d.get("Classes") );
                list.add(course);
            }

            try {
                request.setAttribute("course", list);
                RequestDispatcher de = request.getRequestDispatcher("/table.jsp");
                de.forward(request, response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // reader can only be closed when there is no need to access the documents any more
            reader.close();
        }
        catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
 
    private void gotoLogin(PrintWriter out, HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String psd = request.getParameter("psd");

        if(Student.getName().equals(name) && Student.getPsd().equals(psd)){
            try{
                RequestDispatcher de=request.getRequestDispatcher("/search.html");  
                de.forward(request, response);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else if(Teacher.getName().equals(name) && Teacher.getPsd().equals(psd)){
            String msg="You are a teacher";  
            String title="Teacher";  
            gotoMsg(out, request, response,title,msg);
        }
        else{
            String msg="Wrong Name or Password";  
            String title="Error";  
            gotoMsg(out, request, response,title,msg);
        }
    }
    
    private void gotoMsg(PrintWriter out, HttpServletRequest request, HttpServletResponse response, String title, String msg) {
        request.setAttribute("msg", msg);
        request.setAttribute("title", title);
        RequestDispatcher de = request.getRequestDispatcher("/message.jsp");
        try {
            de.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void gotoEnroll(PrintWriter out, HttpServletRequest request, HttpServletResponse response){
        String msg="You have enrolled in " + request.getParameter("id") + ": " + request.getParameter("id");  
        msg+= "\n";
        msg+=request.getParameter("description");
        String title="Enroll Success";  
        gotoMsg(out, request, response,title,msg);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
