from playwright.sync_api import Page, expect

def test_login_mail(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.fill('input#email', 'zhiger.zhamakyshev@gmail.com')
    page.fill('input#password', 'KZiKVS')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-success alert-nobg']")).to_be_visible()

def test_login_login(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.fill('input#email', 'User447')
    page.fill('input#password', 'KZiKVS')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-success alert-nobg']")).to_be_visible()

def test_login_invalidlogin(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.fill('input#email', 'User444')
    page.fill('input#password', 'KZiKVS')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-danger']")).to_be_visible()

def test_login_invalidpas(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.fill('input#email', 'User447')
    page.fill('input#password', 'KZiKVSS')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-danger']")).to_be_visible()

def test_login_emptylogin(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.fill('input#password', 'KZiKVSS')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-danger']")).to_be_visible()

def test_login_emtypas(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.fill('input#email', 'User447')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-danger']")).to_be_visible()

def test_login_empty(page: Page):
    page.goto('https://gymlog.ru/profile/login/')
    page.click('button[type="submit"]')
    expect(page.locator("//div[@class='alert result alert-danger']")).to_be_visible()

def test_register(page: Page):
    page.goto('https://gymlog.ru/')
    page.fill('input[name=email]', 'zhiger.zhamakyshev@gmail.com')
    page.click('//*[@id="registration-form"]/div[1]/button')
    expect(page.locator("//p[@class='description result error']")).to_be_visible()