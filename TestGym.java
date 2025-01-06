package Test;

import com.microsoft.playwright.*;
import org.junit.Test;

import javax.security.auth.login.Configuration;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestGym {
    @Test
    public void TestAuthEmpty(){
        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-danger']")).isVisible();
        }
    }
    @Test
    public void TestAuthEmptylogin() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.locator("input#password").fill("KZiKVS");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-danger']")).isVisible();
        }
    }
    @Test
    public void TestAuthEmptyPass() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.locator("input#email").fill("User447");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-danger']")).isVisible();
        }
    }
    @Test
    public void TestAuthEmail() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.locator("input#email").fill("zhiger.zhamakyshev@gmail.com");
            page.locator("input#password").fill("KZiKVS");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-success alert-nobg']")).isVisible();
        }
    }
    @Test
    public void TestAuthLogin() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.locator("input#email").fill("User447");
            page.locator("input#password").fill("KZiKVS");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-success alert-nobg']")).isVisible();
        }
    }
    @Test
    public void TestAuthInvalidLogin() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.locator("input#email").fill("User444");
            page.locator("input#password").fill("KZiKVS");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-danger']")).isVisible();
        }
    }
    @Test
    public void TestAuthInvalidPass() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/profile/login/");
            page.locator("input#email").fill("User447");
            page.locator("input#password").fill("KZiKVSS");
            page.click("button[type='submit']");
            assertThat(page.locator("//div[@class='alert result alert-danger']")).isVisible();
        }
    }
    @Test
    public void TestReg() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://gymlog.ru/");
            page.locator("//*[@id='registration-form']/div[1]/input").fill("zhiger.zhamakyshev@gmail.com");
            page.click("//*[@id='registration-form']/div[1]/button");
            assertThat(page.locator("//p[@class='description result error']")).isVisible();
        }
    }
}