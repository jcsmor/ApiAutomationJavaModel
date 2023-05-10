Feature: ABP Chromium - Basic Functionality

  @AA_OFF
  Scenario Outline: Get bytes received with ABP disabled
    Given I go to AdBlocking Settings
    And I wait until extensions are installed
    And I disable ABP
    When I go to "<url>" and get bytes received
    Then I save AA disabled data performance values

    Examples:
      | url                                                                                     |
      | https://www.google.com/search?q=iphone&source=hp&ei=TnIIZMD1CIvagQb8z5mwBA&iflsig=AK50M_UAAAAAZAiAXuaTRudOg_erHsyrE8w6v6roM3OB&ved=0ahUKEwjA1KORnsz9AhULbcAKHfxnBkYQ4dUDCAs&uact=5&oq=iphone&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgsILhCABBDHARDRAzoFCC4QgARQAFj0BmDlB2gAcAB4AIABV4gBvQOSAQE2mAEAoAEB&sclient=gws-wiz |
      | https://www.youtube.com/watch?v=G8nNGk6LHaM |
      | https://www.facebook.com/ |
      | https://www.instagram.com/ |
#      | https://twitter.com/search?q=%23Bachmut&src=trend_click&vertical=trends |
#      | https://tieba.baidu.com/f/search/res?qw=%E2%80%9C%E6%95%B0%E8%AF%B4%E2%80%9D%E4%B8%AD%E5%9B%BD%E8%BF%99%E4%BA%94%E5%B9%B4&sm=2&cf=1&ie=utf-8 |
#      | https://tieba.baidu.com/p/3649627706?pid=65892585589&cid=0#65892585589 |
#      | https://www.amazon.com/ |
#      | https://www.amazon.com/Philips-LED-Flicker-Free-Certified-3-Pack/dp/B07VMBGJHX/?_encoding=UTF8&pd_rd_w=5W2Xv&content-id=amzn1.sym.d6aaa73e-4455-44fa-88a3-6e1ae26769ee&pf_rd_p=d6aaa73e-4455-44fa-88a3-6e1ae26769ee&pf_rd_r=YSNGEYS4QCDRS31D2ER3&pd_rd_wg=6Zk45&pd_rd_r=71a54ac0-45fa-4b00-8535-e766e4d362d1&ref_=pd_gw_exports_top_sellers_unrec&th=1 |
#      | https://www.amazon.com/Non-Dimmable-Daylight-Replacement-Recessed-100%C2%B0Flood/dp/B01EWBZPD4?pd_rd_w=Erp8W&content-id=amzn1.sym.56b6d1e1-8781-4e32-a7bc-5298ad4b88ac&pf_rd_p=56b6d1e1-8781-4e32-a7bc-5298ad4b88ac&pf_rd_r=EZRGEZGM1FVB679RAQZ7&pd_rd_wg=VAmXr&pd_rd_r=a0166dd4-b800-4157-825c-66a2d3ac4b08&ref_=sspa_dk_detail_1&th=1 |
#      | https://www.yahoo.com/ |
#      | https://finance.yahoo.com/ |
#      | https://finance.yahoo.com/news/bitcoin-next-gamestop-word-street-095125128.html |
#      | https://search.yahoo.com/search;_ylt=AwrFQMWYBAtk_JkKWEFDDWVH;_ylc=X1MDMTE5NzgwNDg2NwRfcgMyBGZyAwRmcjIDcDpzLHY6c2ZwLG06c2ItdG9wBGdwcmlkA3hUMEJhTWRJUXouRHNCY1NNSWNXVUEEbl9yc2x0AzAEbl9zdWdnAzEwBG9yaWdpbgNzZWFyY2gueWFob28uY29tBHBvcwMwBHBxc3RyAwRwcXN0cmwDMARxc3RybAM5BHF1ZXJ5A2lwaG9uZSUyMDEyBHRfc3RtcAMxNjc4NDQzNzIy?p=iphone+12&fr=sfp&fr2=p%3As%2Cv%3Asfp%2Cm%3Asb-top&iscqry= |
#      | https://www.tiktok.com/foryou |
#      | https://outlook.live.com/mail/0/ |
#      | https://www.linkedin.com/feed/ |
#      | https://www.linkedin.com/in/mayamedena1/ |
#      | https://www.yahoo.co.jp/ |
#      | https://news.yahoo.co.jp/articles/b0aabb7ad20ae90fc042c33ab813d2b380ec0d7e |
#      | https://www.reddit.com/ |
#      | https://www.naver.com/ |
#      | https://www.pinterest.com/ |
#      | https://www.bing.com/?toWww=1&redig=BF0091AC32E24BFBB8FF8AB6C8C18D00 |
#      | https://www.ebay.com/b/Jordan-1-Chicago-Lost-Found-2022/15709/bn_7118597235 |
#      | https://www.ebay.com/b/Home-Garden/11700/bn_1853126 |
#      | https://www.google.com.br/search?q=shoes&source=hp&ei=aBILZNm5NNCr5NoP2fapmAU&iflsig=AK50M_UAAAAAZAsgeDMKX8WXrOarTk0KiwZ9TFlFaQ9Y&ved=0ahUKEwjZjaKNn9H9AhXQFVkFHVl7ClMQ4dUDCAo&uact=5&oq=shoes&gs_lcp=Cgdnd3Mtd2l6EAMyDgguEIAEELEDEMcBENEDMggIABCABBCxAzIFCAAQgAQyDgguEIAEELEDEMcBENEDMg4ILhCABBCxAxDHARDRAzIFCAAQgAQyCwguEIMBELEDEIAEMggIABCABBCxAzIICAAQgAQQsQMyDgguEIAEELEDEMcBENEDOhEILhCABBCxAxCDARDHARDRAzoLCAAQgAQQsQMQgwE6CAgAELEDEIMBOgUILhCABDoLCC4QsQMQgwEQ1AI6DggAEI8BEOoCEIwDEOUCOggILhCxAxCDAToRCC4QgwEQxwEQsQMQ0QMQgAQ6DgguEIMBEMcBELEDENEDOggILhCABBCxAzoICC4QgwEQsQM6CwguEIAEELEDEIMBOgcIABCABBAKOgsILhCABBCxAxDUAjoQCAAQgAQQsQMQgwEQsQMQCjoNCAAQgAQQsQMQgwEQCjoICC4QgAQQ1AI6CwguEIAEEMcBENEDUABYxCpgtCtoA3AAeACAAd8BiAHoCJIBBTAuNi4xmAEAoAEBsAEK&sclient=gws-wiz#ip=1 |
#      | https://www.google.com.br/search?q=shoes&source=hp&ei=QxMLZPPtH8-p5NoP9aSfqA0&iflsig=AK50M_UAAAAAZAshU3oZJMlPNGn9NsUfWTg9wZJDlynB&ved=0ahUKEwizm8T1n9H9AhXPFFkFHXXSB9UQ4dUDCAo&uact=5&oq=shoes&gs_lcp=Cgdnd3Mtd2l6EAMyBwgAELEDEEMyDgguEIAEELEDEMcBENEDMgcIABCxAxBDMgQIABBDMgUIABCABDIHCAAQsQMQQzIECAAQQzIOCC4QgAQQsQMQxwEQ0QMyDgguEIAEELEDEMcBENEDMgcIABCxAxBDOgoIABCxAxCDARBDUABY0glgvgpoAHAAeACAAY8BiAGiBJIBAzAuNJgBAKABAQ&sclient=gws-wiz |
#      | https://www.msn.com/ |
#      | https://www.msn.com/en-us/entertainment/entertainment-celebrity/10-most-hated-hollywood-actors/ss-AA18pyfb?ocid=hpmsn&cvid=7cba27bcbed84a5b929f450c9c02ad7b&ei=33#image=2 |
#      | https://www.msn.com/en-us/movies?ocid=hpmsn&cvid=7cba27bcbed84a5b929f450c9c02ad7b&ei=44 |
#      | https://www.msn.com/en-us/entertainment/entertainment-celebrity/10-most-hated-hollywood-actors/ss-AA18pyfb?ocid=hpmsn&cvid=7cba27bcbed84a5b929f450c9c02ad7b&ei=33 |
#      | https://duckduckgo.com/?q=shoes&t=h_&ia=web |
#      | https://weather.com/weather/hourbyhour/l/3397f813e2a7833d07c1756bf7fb0ff62a68918b04566dcd9ccb15451a0a2a64 |
#      | https://weather.com/ |
#      | https://www.booking.com/ |
#      | https://www.booking.com/searchresults.html?ss=New+York%2C+United+States+of+America&efdco=1&label=gen173nr-1FCAEoggI46AdIM1gEaKcCiAEBmAExuAEXyAEM2AEB6AEB-AECiAIBqAIDuAKhuKygBsACAdICJDZhNjIyMzFhLWUyZGMtNGQ5Mi04OWFjLTYzY2UzZTNiN2VjZtgCBeACAQ&aid=304142&lang=en-us&sb=1&src_elem=sb&src=index&group_adults=2&no_rooms=1&group_children=0&sb_travel_purpose=leisure |
#      | https://www.fandom.com/ |
#      | https://genshin-impact.fandom.com/wiki/Xinyan |
#      | https://www.fandom.com/articles/john-wick-chapter-4-exclusive-poster |
#      | https://www.amazon.co.jp/-/en/Tools-Whisk-Strainer-Stove-Ceramic/dp/B07NHFJ64D/?_encoding=UTF8&pd_rd_w=WwRJD&content-id=amzn1.sym.b173a2df-735b-4d3d-8f1b-9b9a5b29af69&pf_rd_p=b173a2df-735b-4d3d-8f1b-9b9a5b29af69&pf_rd_r=CVMJ1BNVCMKCZ71H8726&pd_rd_wg=n4hSU&pd_rd_r=94dd9c61-1af2-4a93-9cd7-d15663208c08&ref_=pd_gw_exports_top_sellers_unrec_jp |
#      | https://www.amazon.de/b/?node=412356031&ref_=de_ais_gw_Q1&pf_rd_r=3J54JK8SZ3W7VC42CMG4&pf_rd_p=941e2ae2-08ce-47f9-806a-d3d01f2e41e5&pd_rd_r=0106aefb-d78e-47f1-879d-3a3ac3c31de9&pd_rd_w=uyxqh&pd_rd_wg=FFy23 |
#      | https://www.amazon.de/HyperX-QuadCast-Boom-Stand-Professioneller/dp/B08V1KWX37/ref=lp_412356031_1_11?sbo=RZvfv%2F%2FHxDF%2BO5021pAnSA%3D%3D&th=1 |
#      | https://www.imdb.com/ |
#      | https://www.imdb.com/chart/toptv/?ref_=nv_mp_tv250 |
#      | https://www.etsy.com/c/clothing-and-shoes?ref=catnav-10923 |
#      | https://www.aajtak.in/ |
#      | https://www.aajtak.in/sports |
#      | https://www.aajtak.in/india/news/story/delhi-excise-policy-case-minister-manish-sisodia-in-rouse-avenue-court-ntc-1651812-2023-03-10 |
#      | https://www.google.de/search?q=shoes&source=hp&ei=1icLZPXTC5irptQPzbuC0A0&iflsig=AK50M_UAAAAAZAs15haNhxq0tCsEAgZLfnh4V6vjrQV0&ved=0ahUKEwj1lvDEs9H9AhWYlYkEHc2dANoQ4dUDCAo&uact=5&oq=shoes&gs_lcp=Cgdnd3Mtd2l6EAMyCggAEIAEELEDEAoyDQgAEIAEELEDEIMBEAoyDQgAEIAEELEDEMkDEAoyCggAEIAEELEDEAoyCggAEIAEELEDEAoyBwgAEIAEEAoyEAguEIAEELEDEMcBENEDEAoyCggAEIAEELEDEAoyCggAEIAEELEDEAoyCggAEIAEELEDEAo6DggAEOoCELQCENkCEOUCOggILhCPARDqAjoICAAQjwEQ6gI6CwgAEIAEELEDEIMBOggILhCxAxCDAToOCC4QgwEQxwEQsQMQ0QM6EQguEIMBEMcBELEDENEDEIAEOg4ILhCABBCxAxDHARDRAzoFCC4QgAQ6CAguEIAEELEDOhEILhCABBCxAxCDARDHARDRAzoICC4QgwEQsQM6CwguEIAEELEDEIMBOggIABCABBCxAzoLCC4QgAQQsQMQ1AI6BQgAEIAEOgsILhCDARCxAxCABFCeHFjgI2DDJmgBcAB4AIABrQGIAacGkgEDMC41mAEAoAEBsAEK&sclient=gws-wiz |
#      | https://www.quora.com/ |
#      | https://smg.quora.com/ |
#      | https://www.quora.com/What-record-did-Demi-Moore-set |
#      | https://news.yahoo.co.jp/ |
#      | https://news.yahoo.co.jp/articles/ce2ab209ed620ec73d0bda3236986874e025d184 |
#      | https://www.zillow.com/munising-mi/?searchQueryState=%7B%22pagination%22%3A%7B%7D%2C%22usersSearchTerm%22%3A%2249862%22%2C%22mapBounds%22%3A%7B%22west%22%3A-87.21127510070801%2C%22east%22%3A-86.48343086242676%2C%22south%22%3A46.240117680367824%2C%22north%22%3A46.68094883466938%7D%2C%22regionSelection%22%3A%5B%7B%22regionId%22%3A26042%2C%22regionType%22%3A6%7D%5D%2C%22isMapVisible%22%3Atrue%2C%22filterState%22%3A%7B%22sort%22%3A%7B%22value%22%3A%22globalrelevanceex%22%7D%2C%22ah%22%3A%7B%22value%22%3Atrue%7D%7D%2C%22isListVisible%22%3Atrue%7D |
#      | https://www.globo.com/ |
#      | https://ge.globo.com/ce/futebol/times/fortaleza/noticia/2023/03/10/analise-fortaleza-bombardeia-cerro-mas-esbarra-em-jean-e-na-propria-ineficiencia-ofensiva.ghtml |
#      | https://www.amazon.co.uk/s?k=nike+shoes&crid=21N8WBPJEA63S&sprefix=nike+sho%2Caps%2C473&ref=nb_sb_noss_2 |
#      | https://www.amazon.co.uk/Nike-Downshifter-Running-Black-Smoke/dp/B08QBFM87X/ref=sr_1_42?crid=21N8WBPJEA63S&keywords=nike%2Bshoes&qid=1678462805&sprefix=nike%2Bsho%2Caps%2C473&sr=8-42&th=1 |
#      | https://www.aliexpress.com/category/100003109/women's-clothing.html?category_redirect=1&spm=a2g0o.home.101.1.64ea2145oNM59Y |
#      | https://www.google.co.jp/search?q=iphone&source=hp&ei=9EkLZLrNCuOvqtsP46OJqAQ&iflsig=AK50M_UAAAAAZAtYBFD2ZbsjWaOmSC-3PWWQLMuGSgEN&ved=0ahUKEwi6l8iJ1NH9AhXjl2oFHeNRAkUQ4dUDCAo&uact=5&oq=iphone&gs_lcp=Cgdnd3Mtd2l6EAMyCgguELEDEOUEEEMyCgguELEDEOUEEEMyCgguELEDEOUEEEMyCgguELEDEOUEEEMyCgguELEDEOUEEEMyCgguELEDEOUEEEMyCgguELEDEOUEEEMyCgguEOUEENQCEEMyDQguELEDEOUEENQCEEMyCgguELEDEOUEEEM6CwgAEIAEELEDEIMBOhEILhCABBCxAxCDARDHARDRAzoOCC4QgAQQsQMQxwEQ0QM6CAgAELEDEIMBOgsILhCABBDHARDRAzoLCC4QsQMQgwEQ1AI6CwguEIAEELEDEIMBOgQILhBDOgcILhDlBBBDUABYpwZgmQhoAHAAeACAAakCiAGlCpIBAzItNZgBAKABAQ&sclient=gws-wiz#ip=1 |
#      | https://www.uol.com.br/ |
#      | https://noticias.uol.com.br/politica/ultimas-noticias/2023/03/10/stf-votacao-processos-decreto-lula-antiarmas.htm |
#      | https://www.uol.com.br/esporte/ |
#      | https://www.walmart.com/shop/deals?povid=GlobalNav_rWeb_Deals_Deals_ShopAllDeals |
#      | https://www.walmart.com/ |
#      | https://nhentai.net/ |
#      | https://nhentai.net/artists/ |
#      | https://www.amazon.in/ |
#      | https://www.amazon.in/Kleenex-Facial-Tissue-Sheets-Kimberly-Clark/dp/B01M29XDK0/ref=lp_21955490031_1_1?sbo=EO%2BcdOgoisx3waG5xqcZQA%3D%3D&th=1 |
#      | https://www.amazon.in/ref=nav_logo |
#      | https://www.accuweather.com/ |
#      | https://www.accuweather.com/en/winter-weather/northeast-weather-winter-storm-snow-noreaster/1494892 |
#      | https://www.cnn.com/ |
#      | https://www.cnn.com/2023/03/10/us/matamoros-mexico-americans-kidnapped-friday/index.html |
#      | https://www.cnn.com/politics |
#      | https://www.espn.com/nba/story/_/id/35825208/fred-vanvleet-fined-30k-says-officiating-criticism-unfortunate |
#      | https://www.espn.com/ |
#      | https://www.espn.com/nhl/ |
#      | https://www.google.it/search?q=shoes&source=hp&ei=blkLZMvAJsOwqtsPsfKRqAg&iflsig=AK50M_UAAAAAZAtnfqr-EBVTvF4-e5X5xxiwhY8dEabm&ved=0ahUKEwjLr4Hr4tH9AhVDmGoFHTF5BIUQ4dUDCAo&uact=5&oq=shoes&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMg4ILhCABBCxAxDHARDRAzIFCAAQgAQyDgguEIAEELEDEMcBENEDMgUIABCABDILCAAQgAQQsQMQgwEyCAguELEDEIAEMggIABCABBCxAzIICAAQgAQQsQMyCwgAEIAEELEDEIMBOhEILhCDARDHARCxAxDRAxCABDoOCC4QgwEQxwEQsQMQ0QM6CAgAELEDEIMBOgUILhCABDoICC4QsQMQgwE6CwguEIAEEMcBENEDOggILhCABBCxAzoLCC4QgwEQsQMQgAQ6CwguEIAEELEDENQCOgsILhCxAxDHARDRAzoLCC4QgAQQsQMQgwE6CwgAEIAEELEDEMkDUABY4gRg8wVoAHAAeACAAeoBiAGbB5IBAzItNJgBAKABAQ&sclient=gws-wiz |
#      | https://www.google.co.uk/search?q=shoes&source=hp&ei=sFkLZICaK8i4qtsP3eGq2AE&iflsig=AK50M_UAAAAAZAtnwIxRN5rYmfxAdRvOZuMiKq6T6cYr&ved=0ahUKEwiAssKK49H9AhVInGoFHd2wChsQ4dUDCAo&uact=5&oq=shoes&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMg4ILhCABBCxAxDHARDRAzIFCAAQgAQyDgguEIAEELEDEMcBENEDMgUIABCABDILCAAQgAQQsQMQgwEyCAguELEDEIAEMggIABCABBCxAzIICAAQgAQQsQMyCwgAEIAEELEDEIMBOhEILhCDARDHARCxAxDRAxCABDoOCC4QgwEQxwEQsQMQ0QM6CAgAELEDEIMBOgUILhCABDoICC4QsQMQgwE6CwguEIAEEMcBENEDOggILhCABBCxAzoLCC4QgwEQsQMQgAQ6CwguEIAEELEDENQCOgsILhCxAxDHARDRAzoLCC4QgAQQsQMQgwE6CwgAEIAEELEDEMkDUABYtgRglwVoAHAAeACAAeoBiAGBB5IBAzItNJgBAKABAQ&sclient=gws-wiz |
#      | https://www.pixiv.net/en/tags/k |
#      | https://www.google.fr/search?q=shoes&source=hp&ei=vVYLZJzrGf2kqtsP_8G8yAE&iflsig=AK50M_UAAAAAZAtkzfkClU3gcsAvFrERZXtHoVN14c75&ved=0ahUKEwjcva-i4NH9AhV9kmoFHf8gDxkQ4dUDCAo&uact=5&oq=shoes&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMg4ILhCABBCxAxDHARDRAzIFCAAQgAQyDgguEIAEELEDEMcBENEDMgUIABCABDILCAAQgAQQsQMQgwEyCAguELEDEIAEMggIABCABBCxAzIICAAQgAQQsQMyCwgAEIAEELEDEIMBOggILhCxAxCDAToICC4QgAQQsQM6CwguEIMBELEDEIAEOgUILhCABDoLCC4QgAQQsQMQ1AI6CwguELEDEMcBENEDOgsILhCABBCxAxCDAToLCC4QgAQQxwEQ0QM6CwgAEIAEELEDEMkDUABY9wNgjgVoAHAAeACAAawCiAGOBpIBBTItMi4xmAEAoAEB&sclient=gws-wiz |
