package com.manulife.jp.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
	@RequestMapping("/getData")
	public String hi() throws ClientProtocolException, IOException {
		
		String url_str = "https://graph.microsoft.com/users";
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
				"Tetsuaki_Matsumoto@mljpabeta.onmicrosoft.com", "Jud4105501");
		provider.setCredentials(AuthScope.ANY, credentials);
		HttpClient client = HttpClientBuilder.create()
				.setDefaultCredentialsProvider(provider).build();
		HttpGet request = new HttpGet(url_str);
		String token1 = "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IkFRQUJBQUFBQUFDNXVuYTBFVUZnVElGOEVsYXh0V2pUMlRSSGZRTzZmMEMyY1pHeWJYNFlXd091ZktOVWZ5ZWFKSHNiMjBlWW10WF95T1YyanQ5RXRUb3RCcm92TWdkQWt6MmJFZ2s0dWw0T2ZBZEFncG9MWlNBQSIsImFsZyI6IlJTMjU2IiwieDV0Ijoid1VMbVlmc3FkUXVXdFZfLWh4VnRESkpaTTRRIiwia2lkIjoid1VMbVlmc3FkUXVXdFZfLWh4VnRESkpaTTRRIn0.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84OThmNDVmMy02OTE5LTRjOTgtODJlNi02MjFiYmZmYTFjZjAvIiwiaWF0IjoxNTQzOTI4NjIyLCJuYmYiOjE1NDM5Mjg2MjIsImV4cCI6MTU0MzkzMjUyMiwiYWlvIjoiNDJSZ1lHRCtmb0ZsYnNLUERHM0hiZHJGekovWUFBPT0iLCJhcHBfZGlzcGxheW5hbWUiOiJwb3N0bWFuX1Rlc3QiLCJhcHBpZCI6ImU3MWI3NzU4LTRkYTQtNDM0My1hNThlLTJiOGU1NDRiMjFjMCIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0Lzg5OGY0NWYzLTY5MTktNGM5OC04MmU2LTYyMWJiZmZhMWNmMC8iLCJvaWQiOiIyMGQzOGNlOC02YzI0LTQyMWQtOGYxMS05ZDA5NDBhYzU2NzQiLCJyb2xlcyI6WyJVc2VyLlJlYWRXcml0ZS5BbGwiLCJEaXJlY3RvcnkuUmVhZFdyaXRlLkFsbCIsIkRpcmVjdG9yeS5SZWFkLkFsbCIsIlVzZXIuUmVhZC5BbGwiXSwic3ViIjoiMjBkMzhjZTgtNmMyNC00MjFkLThmMTEtOWQwOTQwYWM1Njc0IiwidGlkIjoiODk4ZjQ1ZjMtNjkxOS00Yzk4LTgyZTYtNjIxYmJmZmExY2YwIiwidXRpIjoiY3JJOFB0U1lmazZXbmZMUWRLVjBBQSIsInZlciI6IjEuMCIsInhtc190Y2R0IjoxNTI1ODM3OTcyfQ.Fpao4ytLR2yAUoHKbIJgkWmwV0uNP-JHM5L-yQ3QDDtkx2FkmqFUBZhJt-4xYJW-_WepebbeGy83yFseH-cfVPEmwPsRtl6H7OUAYUGuvrbmpsE5iHhBWhT-Kc9jvD-xlBEMzP866UTOYrmbtB32pevIV8RVOYP7BeH9r-BCtq4DUwSTPEokXG1JV5ieh2NlPWMyIyNrqq9Hnv3PrYPVwkXVsNrm1jtP0hZyKxPg6E61wpn8Jb3181CuSrTBxvvrfUpBYz_BDZGAPzYmYiwDFFvqo6EAUwIligGKtRA1VV8BrenREiZxftnghjztoDpIZzkDs9W5QtEc7Bc0d9Lnlw";
		request.setHeader("Authorization", token1);
		request.setHeader("Content-Type", "application/json");
		
		HttpResponse response = client.execute(request);
		System.out.println("\nSending 'GET' request to URL : " + url_str);
		System.out.println("Response Code : "
				+ response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		/*String access_token = "Bearer eyJ0eXAiOiJKV1QiLCJub25jZSI6IkFRQUJBQUFBQUFDNXVuYTBFVUZnVElGOEVsYXh0V2pUd2hKZXdxT1JCeDZzYVNzUWpudmtON3BnZThRbG5ZVzRZLUR2SW5icHpnLW9DMmdnaEc2NjlJcmo2T1FUeTBhUDRDVThsVXZ0WVBYN0hFV3d3LXE5enlBQSIsImFsZyI6IlJTMjU2IiwieDV0Ijoid1VMbVlmc3FkUXVXdFZfLWh4VnRESkpaTTRRIiwia2lkIjoid1VMbVlmc3FkUXVXdFZfLWh4VnRESkpaTTRRIn0.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84OThmNDVmMy02OTE5LTRjOTgtODJlNi02MjFiYmZmYTFjZjAvIiwiaWF0IjoxNTQzOTkwNDg4LCJuYmYiOjE1NDM5OTA0ODgsImV4cCI6MTU0Mzk5NDM4OCwiYWlvIjoiNDJSZ1lGaWt6YTY2VUZwZWlsZTc3a1JnT1ZNOEFBPT0iLCJhcHBfZGlzcGxheW5hbWUiOiJwb3N0bWFuX1Rlc3QiLCJhcHBpZCI6ImU3MWI3NzU4LTRkYTQtNDM0My1hNThlLTJiOGU1NDRiMjFjMCIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0Lzg5OGY0NWYzLTY5MTktNGM5OC04MmU2LTYyMWJiZmZhMWNmMC8iLCJvaWQiOiIyMGQzOGNlOC02YzI0LTQyMWQtOGYxMS05ZDA5NDBhYzU2NzQiLCJyb2xlcyI6WyJVc2VyLlJlYWRXcml0ZS5BbGwiLCJEaXJlY3RvcnkuUmVhZFdyaXRlLkFsbCIsIkRpcmVjdG9yeS5SZWFkLkFsbCIsIlVzZXIuUmVhZC5BbGwiXSwic3ViIjoiMjBkMzhjZTgtNmMyNC00MjFkLThmMTEtOWQwOTQwYWM1Njc0IiwidGlkIjoiODk4ZjQ1ZjMtNjkxOS00Yzk4LTgyZTYtNjIxYmJmZmExY2YwIiwidXRpIjoiOHN5bjBNaFJZVXlram9XVVZuZ1BBQSIsInZlciI6IjEuMCIsInhtc190Y2R0IjoxNTI1ODM3OTcyfQ.MtuC_qucQEbnRpgxZvvRW7VQOsKxt7krA5NMDHnIblUwrXrJ8Ddq7EZ-6CdV68iu7WuK3K-rvo6NWVK0_Yp_iA-lvYAc8OjsBTaZfRj40bXw-fbduEUR8Xmps5ecer7EkvEKKzjvppaXoQNZl5FNxsZ63dBFrxMIxuG_BLvsK6F6b-n7uB5YvS6ov2-CeS7s_5st65-dQyklbwquVfY_uvVKrLRKBl9cKe_ZpugQjlSUqNZ9kWfIPavCpg4H3Qik1YLz89dWIZPKoy6w4PWQ62WSfwQ29b7TapW7oBKm-O6U7O4hfhU_O_3p8vxjMcVH7UPFKWpNN3qSCGOagrtOIg";
		URL obj = new URL(url_str);
		HttpURLConnection  con = ( HttpURLConnection )obj.openConnection();
	    con.setDoInput(true);
	    con.setDoOutput(true);
	    con.setUseCaches(false);
	    con.setRequestMethod("GET");
	    con.setRequestProperty("Authorization", access_token);
	    con.setRequestProperty("Accept","application/json");
	    con.connect();

	    BufferedReader br = new BufferedReader(new InputStreamReader( con.getInputStream() ));
	    String str = null;
	    String line;
	    while((line = br.readLine()) != null) {
	        str += line;
	    }
	    System.out.println(str);*/
		return result.toString();
	    
			
		}
	}


