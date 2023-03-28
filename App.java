import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {

        //Chamar a minha Api e acessar os dados dessa Api
         //Conexão atraves do HTTP
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
       
        //Extrair os dados que interessam, titulo, poster e classificação
        var parser = new JsonParser();
        List<Map<String, String>> listadeFilmes = parser.parse(body);
        //System.out.println(listadeFilmes.size());
        //System.out.println(listadeFilmes.get(5));
        //Exibir os dados e manipulá-los
        for( Map<String,String> filme : listadeFilmes){
        	
            float contador = 0;
        	
            System.out.println("\u001b[1mTitulo:\u001b[38;2;244;10;176m \u001b[48;2;132;255;222m" + filme.get("title")+ "\u001b[m"); 
            System.out.println("\u001b[1mImagem:\u001b[38;2;27;0;252m \u001b[48;2;31;255;228m" + filme.get("image")+ "\u001b[m");
            Float estrelas = Float.parseFloat(filme.get("imDbRating"));
            System.out.println("\u001b[1mAvaliacao:\u001b[38;2;254;255;1m\u001b[48;2;43;43;43m" + estrelas + "\u001b[m");
            System.out.println();
            while(contador <= estrelas-1){
                contador++;
                String x = "\u2B50";
                System.out.println(x);
            }
            	System.out.println("\n");
        }//for

    }//static void
}//app
