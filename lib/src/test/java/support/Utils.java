package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import runner.RunCucumber;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.io.IOException;

public class Utils extends RunCucumber {

    public static void tiraPrint(String fileName)throws IOException {
    	String caminhoArquivo = "src\\test\\java\\evidencias\\";
        Date dataAtual = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("ddMMyyHHmmss");
        String dataFormatada = formatoData.format(dataAtual);
        String nomeArquivo = fileName + dataFormatada + ".png";
        String file = (caminhoArquivo + nomeArquivo);
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(file));
    }
}
