package day10_FakerKütüphanesi_Filetestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void  test01(){
        System.out.println(System.getProperty("user.dir"));    //D:\com_Batch81UNIT
        //bana içinde oldugum projenin dosya yolunu path verir

        System.out.println(System.getProperty("user.home")); //C:\Users\Leonovo
        // bilgisayarımın bana özel kısmını verdi

    //D:\com_Batch81UNIT\src\test\java\day10_FakerKütüphanesi_Filetestleri dosyamın yolları

     //*** homePath+"/Dowwloads"

  //massa üstümüzdeki text dosyasinin varligini test edin

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.text";
        System.out.println(dosyaYolu);

        //herkeste farklı olan kısım
        String farklıisim=System.getProperty("user.home");
        //herkeste ortak olan kısım
        String  ortakisim="\\Desktop\\text.txt";

        String masaüstüDosyaYolu=farklıisim+ortakisim;

       // System.out.println(Files.exists(Paths.get(masaüstüDosyaYolu)));   //true ya da false yazacak

        Assert.assertTrue(Files.exists(Paths.get(masaüstüDosyaYolu)));


    }
}
