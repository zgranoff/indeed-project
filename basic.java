import java.io.*;
public class basic
{
  public static void main (String[] args)throws IOException
  {
    BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

    System.out.println("Enter Job Title");
    String jobTitle = inp.readLine();
    /*
    //returns a list of jobs
    // These code snippets use an open-source library. http://unirest.io/java
    HttpResponse<JsonNode> response = Unirest.get("https://indeed-indeed.p.mashape.com/apigetjobs?publisher=&format=json&jobkeys=<" + jobTitle + ">&v=2")
    .header("X-Mashape-Key", "uwcEdQfVJhmshqwUXBmkl2Di1XaNp1TawJDjsnI4Jv6SL6rpd3")
    .header("Accept", "application/json")
    .asJson();
    */
    //Callback. The name of a javascript function to use as a callback to which the results of the search are passed. This only applies when format=json. For security reasons, the callback name is restricted letters, numbers, and the underscore character.
    System.out.println("Enter Java Callback");
    String javaFormatCallback = inp.readLine();
    //Channel Name: Group API requests to a specific channel
    System.out.println("Enter Java Format Channel");
    String javaFormatChannel = inp.readLine();
    //Search within country specified. Default is us. See below for a complete list of supported countries.
    System.out.println("Enter Job Country");
    String jobCountry = inp.readLine();
    //Filter duplicate results. 0 turns off duplicate job filtering. Default is 1.
    System.out.println("Enter Job Duplicate");
    String jobDuplicates = inp.readLine();
    //Format. Which output format of the API you wish to use. The options are "xml" and "json." If omitted or invalid, the XML format is used.
    System.out.println("Enter Java Format");
    String javaFormat = inp.readLine();
    //Number of days back to search.
    System.out.println("Enter Job Day Posted");
    String jobDateUploaded = inp.readLine();
    //Setting this value to 1 will bold terms in the snippet that are also present in q. Default is 0.
    System.out.println("Enter Job Results Highlight");
    String keyWordHighlight = inp.readLine();
    //Job type. Allowed values: "fulltime", "parttime", "contract", "internship", "temporary".
    System.out.println("Enter Job Type");
    String jobType = inp.readLine();
    //Location. Use a postal code or a "city, state/province/region" combination.
    System.out.println("Enter Job Location");
    String jobLocation = inp.readLine();
    System.out.println("Enter Job Count Limit");
    String jobCountLimit = inp.readLine();
    //Sort by relevance or date. Default is relevance.
    System.out.println("Enter Job Sort");
    String jobSort = inp.readLine();
    //Site type. To show only jobs from job boards use 'jobsite'. For jobs from direct employer websites use 'employer'.
    System.out.println("Enter Job Site Type");
    String jobSiteType = inp.readLine();
    //Start results at this result number, beginning with 0. Default is 0.
    System.out.println("Enter Job Start Results");
    String jobSearchStart = inp.readLine();
    //The User-Agent (browser) of the end-user to whom the job results will be displayed. This can be obtained from the "User-Agent" HTTP request header from the end-user. This field is required
    System.out.println("Enter User Browser");
    String javaUserAgent = inp.readLine();
    //The IP number of the end-user to whom the job results will be displayed. This field is required.
    System.out.println("Enter User IP Adderss");
    String javaUserIP = inp.readLine();

    /*
    // These code snippets use an open-source library. http://unirest.io/java
    HttpResponse<JsonNode> response = Unirest.get("https://indeed-indeed.p.mashape.com/apisearch?publisher=&callback=<" + javaFormatCallback + ">&chnl=<" + javaFormatChannel + ">&co=<" + jobCountry + ">&filter=<" + jobDuplicates +
    ">&format= <" + javaFormat + ">&json&fromage=<" + jobDateUploaded + ">&highlight=<" + keyWordHighlight + ">&jt=<" + jobType + ">&l=<" + jobLocation + ">%2C+tx&latlong=<" + 0 + ">&limit=<" + jobCountLimit +
    ">&q=java&radius=25&sort=<" + jobSort + ">&st=<" + jobSiteType +
    ">&start=<" + jobSearchStart + ">&useragent=<" + javaUserAgent + ">&userip=<" + javaUserIP + ">&v=2")
    .header("X-Mashape-Key", "7i7pTYZCpWmshnDlQjg5p6VH6Fo4p1g4edJjsnsfugze775hoQ")
    .header("Accept", "application/json")
    .asJson();
    */
  }
}
