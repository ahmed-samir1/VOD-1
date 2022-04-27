package Vod_T;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Vod_search extends BaseTest {

    //String search_keyword = "Selenium Tutorial";




    @Test(priority = 1)
    public void test_Search_SeleniumTutorial_Thirdvideo_results(Method method) throws InterruptedException {

        searchpage.searchUsingSearchButton("Selenium Tutorial");
        searchpage.filter();
        searchpage.selectvideotype();
        String title_searchpage1= searchpage.getTitleFromSearchPage(3);
        System.out.println("first title" + title_searchpage1);
        Thread.sleep(10000);
        searchpage.click_on_vedio(3);
        Thread.sleep(10000);
        searchpage.get_title_under_video();
        String title_videopage1 = searchpage.get_title_under_video();
        System.out.println("second title" +title_videopage1);
        Assert.assertEquals(title_searchpage1,title_videopage1);
    }
    @Test(priority = 2)
    public void test_Search_TestAutomationTutorial_Thirdvideo_results(Method method) throws InterruptedException {


        searchpage.searchUsingSearchButton("Test Automation Tutorial");
        searchpage.filter();
        searchpage.selectvideotype();
        String title_searchpage2= searchpage.getTitleFromSearchPage(3);
        System.out.println("first title" + title_searchpage2);
        Thread.sleep(10000);
        searchpage.click_on_vedio(3);
        Thread.sleep(10000);
        searchpage.get_title_under_video();
        String title_videopage2 = searchpage.get_title_under_video();
        System.out.println("second title" +title_videopage2);
      
        Assert.assertEquals(title_searchpage2,title_videopage2);
    }
    @Test(priority = 3)
    public void test_Search_SeleniumTutorial_10thvideo_results(Method method) throws InterruptedException {

        searchpage.searchUsingSearchButton("Selenium Tutorial");
        searchpage.filter();
        searchpage.selectvideotype();
        String title_searchpage3= searchpage.getTitleFromSearchPage(10);
        System.out.println("first title" + title_searchpage3);
        Thread.sleep(10000);
        searchpage.click_on_vedio(10);
        Thread.sleep(10000);
        searchpage.get_title_under_video();
        String title_videopage3 = searchpage.get_title_under_video();
        System.out.println("second title" +title_videopage3);
      
        Assert.assertEquals(title_searchpage3,title_videopage3);
    }
}
