const titleHero = document.getElementById("title-hero");
const subtitleHero = document.getElementById("subtitle-hero");
const hero = document.getElementById("heroSection");
const saibaMaisBtn = document.getElementById("saibaMaisBtn");
   document.getElementById("jogos").addEventListener("click", ()=>{
        titleHero.innerText = "Lançamento!"
        subtitleHero.innerText = "Returnal é um jogo de tiro em terceira pessoa roguelike desenvolvido pela Housemarque";
        hero.style.backgroundImage="url(img/returnal-game.jpg)"; 
        saibaMaisBtn.setAttribute('href', "https://www.playstation.com/pt-br/games/returnal/");
   });
   document.getElementById("psn").addEventListener("click", ()=>{
        titleHero.innerText = "PSN!"
        subtitleHero.innerText = "Assine já a PSN e aproveite os nossos benefícios!";
        hero.style.backgroundImage="url(img/psn.jpg)"; 
        saibaMaisBtn.setAttribute('href', "https://store.playstation.com/pt-br/");
    });
    document.getElementById("novidades").addEventListener("click", ()=>{
        titleHero.innerText = "Novidades!"
        subtitleHero.innerText = "Todos mês um game novo para você!";
        hero.style.backgroundImage="url(img/novidades.png)";
        saibaMaisBtn.setAttribute('href', "https://store.playstation.com/pt-br/latest");
    });
    document.getElementById("suporte").addEventListener("click", ()=>{
        titleHero.innerText = "Suporte!"
        subtitleHero.innerText = "Está precisando de ajuda? Contate nosso suporte 24h!";
        hero.style.backgroundImage="url(img/suporte.jpg)"
        saibaMaisBtn.setAttribute('href', "https://www.sony.com.br/electronics/support");

    });
