<!DOCTYPE html>
<html>
<head>
<style>
body{
	padding: 0px;
    margin: 0px;
	background-color: rgba(91, 143, 97, 0.25);
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #04AA6D;
}

li {
  float: left;
  border-right:1px solid #bbb;
}
li:last-child {
  text-transform: uppercase;
  font-style:italic;
  border-right: none;
  color: aliceblue;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  transition: 150ms all linear;
}

li a:hover:not(.active) {
  background-color: rgb(0, 44, 22);
}
img{
  border: 2px solid rgba(86, 255, 137, 0.445);
  border-radius: 5px;
  box-shadow: -2px 0px 15px 5px #0d470965;
}
.active {
  background-color: #04AA6D;
}
p{
  font-size: 18px;
  font-weight: bolder;
}
</style>
<link rel="shortcut icon" href="https://pt.seaicons.com/wp-content/uploads/2015/10/movie-folded-icon.png" />
<title>Locadora - Index</title>
</head>
<body>

<ul>
  <li><a href="TituloManterController">Titulo</a></li>
  <li><a href="DiretorManterController"> Diretor</a> </li>
  <li><a href="ClasseManterController">Classe</a></li>
  <li><a href="AtorManterController">Ator </a></li>
  <li style="float: right;"><a href="index.jsp">Locadora dos melhores filmes!</a></li>
</ul>
<section style="text-align:center;">
  <h2>Locadora</h2>
  <img src="https://s2.glbimg.com/IVuvafBxsPCTVTgTej9fRWGcPbg=/0x0:3264x1836/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2018/A/s/luBbMhQbi6ajdo9ynl1g/aaimg-20180124-152359531.jpg" alt="locadora-img">
	<p>
		Locadora de vídeo ou videoclube ou clube de vídeo é um estabelecimento físico de varejo que oferece
		serviços de aluguel de vídeos como filmes, programas de TV pré-gravados, jogos eletrônicos e outros conteúdos.
	</p>
</section>
</body>
</html>
