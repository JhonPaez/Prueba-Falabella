package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Escenario1Test {

	//Driver
	WebDriver driver;	

	@Rule
	public TestName testName = new TestName();
				
	@Before
	public void inicializardriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriver\\IEDriverServer.exe");
		driver = new ChromeDriver();
		//driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
					
	@After
	public void cerrardriver() throws IOException {
		driver.quit();
	}	

	@Test
	public void Escenatio1Test() 
			throws  InterruptedException {		
		
		//Cargar Datos para HomePage
		String usuario="jhonpaez27@gmail.com";
		String contrasena="prueba1234";	
		String buscar="Ramir";	
				
		        //Ingresar a la Página	
		        driver.navigate().to("https://www.linkedin.com/");        
		    
		        //Maximiza la ventana del navegador
		        driver.manage().window().maximize();
		        
		        // Ingresa Usuario y contraseña
		        driver.findElement(By.id("login-email")).sendKeys(usuario);
		        driver.findElement(By.id("login-password")).sendKeys(contrasena);
		        
		        // Presiona boton iniciar sesion
		        driver.findElement(By.id("login-submit")).click();
		        
		        // Ingresa al buscar contacto
		        
		        driver.findElement(By.xpath("//input[contains(@class,'ember-text-field ember-view')]")).sendKeys(buscar);
		        
		        // Presiona el boton buscar
		        driver.findElement(By.id("nav-search-controls-wormhole")).click();
		        
		        // Selecciona el contacto
		        driver.findElement(By.xpath(".//span[@class = 'name actor-name' and contains(text(), 'Ramir Hernández')]")).click();
	        
		        Thread.sleep(5000);	// tiempo opcional para que se visualice el perfil buscado
		
		        driver.close();
	}
}