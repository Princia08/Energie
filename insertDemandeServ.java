package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Service.DemandeService;
import demande.Demande;
import demande.PrevisionRemboursement;


/**
 * Servlet implementation class insertDemandeServ
 */
@WebServlet("/insertDemandeServ")
public class insertDemandeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertDemandeServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String data = "Hello World!";
		String json=request.getParameter("detail");
		/*ObjectMapper mapper = new ObjectMapper();
		HashMap<String,Object> map = mapper.readValue(json, HashMap.class);*/
		/*Enumeration<String> parameterNames = request.getParameterNames();
		
		while (parameterNames.hasMoreElements()) {
			//listeOfParam.add(parameterNames.nextElement());
			System.out.println(parameterNames.nextElement());
		}*/
		
		ObjectMapper mapper = new ObjectMapper();
		Map[] map = mapper.readValue(json, Map[].class);
		
		System.out.println(map.length);
		List<PrevisionRemboursement> li=new ArrayList<PrevisionRemboursement>();
		
		for(Map m : map) {
			PrevisionRemboursement temp=new PrevisionRemboursement();
			temp.setDatePrevision((String)m.get("date"));
			temp.setValeurPrevision((String)m.get("valeur"));
			li.add(temp);
		}
		String valeur=request.getParameter("valeur");
		String date=request.getParameter("date");
		Demande d=new Demande();
		d.setDateUtil(date);
		d.setValeur(valeur);
		
		DemandeService ds=new DemandeService();
		try {
			ds.insertDemande(d, li);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");*/
		//response.getWriter().write(data);
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		String valeur = request.getParameter("valeur");
		Demande d=new Demande();
		CreateConex cr = new CreateConex();
		Connection con = cr.getCon();
		try {
			d.findDemande(valeur, con);
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
