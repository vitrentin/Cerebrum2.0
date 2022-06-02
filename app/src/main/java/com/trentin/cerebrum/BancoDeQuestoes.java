package com.trentin.cerebrum;

import java.util.ArrayList;
import java.util.List;

public class BancoDeQuestoes {
    private static  List<ListaDeQuestoes> questoesDePortugues(){
        final List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();

        // Criar objetos das listas de questões da classe e passar as questôes juntamente com opções e respostas
        final ListaDeQuestoes questao1 = new ListaDeQuestoes("(UFG 2011) A enchente é um fenômeno do regime dos rios, que decorre do ciclo da água. No conto “O que veio de longe”, da obra Livro dos homens, de Ronaldo Correia de Brito, esse fenômeno é representado no processo composicional para", "caracterizar o trajeto do protagonista.", "vincular a narração a um espaço rural.", "demarcar a dimensão linear do enredo.", "refletir a estrutura narrativa da história.", "refletir a estrutura narrativa da história.","");
        final ListaDeQuestoes questao2 = new ListaDeQuestoes("(UFG 2012) Em I-Juca-Pirama, de Gonçalves Dias, o andamento do enredo caracteriza uma obra híbrida entre o trágico e o épico porque","os episódios expressam uma divergência entre os ideais românticos e a cultura indígena.","as ações exprimem a fragilidade do prisioneiro e sua consequente punição, mas isso é superado por sua reação guerreira.","as atitudes do herói explicitam uma indecisão entre a morte honrada e o salvamento do pai.","os eventos narrados evidenciam o amor e a dedicação do prisioneiro ao pai, mas priorizam o sentimento tribal do guerreiro.","as ações exprimem a fragilidade do prisioneiro e sua consequente punição, mas isso é superado por sua reação guerreira.","");
        final ListaDeQuestoes questao3 = new ListaDeQuestoes("Sobre os elementos narrativos que compõem os contos de Murilo Rubião, marque a alternativa correta:","O narrador que predomina é o de terceira pessoa. Sua narrativa demonstra uma onisciência dequem sabe toda a trajetória do personagem.","O desfecho do conto é sempre surpreendente, pois o insólito acaba desaparecendo, e a metamorfose do personagem se encerra.","O insólito substitui a realidade e até o final ela se mantém. Mas sua presença não dá possibilidade de redenção para os personagens.","O contraste entre o tempo linear e a mudança constante do espaço cria o absurdo na narrativa de Murilo Rubião.","O insólito substitui a realidade e até o final ela se mantém. Mas sua presença não dá possibilidade de redenção para os personagens.","");
        final ListaDeQuestoes questao4 = new ListaDeQuestoes("Estão, entre os principais representantes do Orfismo, os seguintes escritores:","Miguel Torga e José Saramago.","Florbela Espanca e Almada Negreiros.","Fernando Pessoa e Mário de Sá-Carneiro.","José Régio e Eça de Queirós.","Fernando Pessoa e Mário de Sá-Carneiro.","");
        final ListaDeQuestoes questao5 = new ListaDeQuestoes("A obra romanesca de José de Alencar introduziu na literatura brasileira quatro tipos de romances: indianista, histórico, urbano e regional. Desses quatro tipos, os que tiveram sua vida prolongada, de forma mais clara e intensa, até o Modernismo, ainda que modificados, foram:","Indianista e histórico","Histórico e urbano","Urbano e regional","Regional e indianista","Urbano e regional","");

        // add todas as questôes para List<ListaDeQuestoes>
        listaDeQuestoes.add(questao1);
        listaDeQuestoes.add(questao2);
        listaDeQuestoes.add(questao3);
        listaDeQuestoes.add(questao4);
        listaDeQuestoes.add(questao5);

        return listaDeQuestoes;
    }
    private static List<ListaDeQuestoes> questoesDeMatematica(){
        final List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();

        // Criar objetos das listas de questões da classe e passar as questôes juntamente com opções e respostas
        final ListaDeQuestoes questao1 = new ListaDeQuestoes("(Fuvest) Ao cobrar uma falta em um jogo de futebol, um jogador imprime à bola uma velocidade de 43,2 km/h. Sabendo que a bola gasta 3 s até atingir as redes, determine a distância percorrida.","36 m","48 m","52 m","28 m","36 m","");
        final ListaDeQuestoes questao2 = new ListaDeQuestoes("(Enem 2020 Digital) Uma associação desportiva contratou uma empresa especializada para construir um campo de futebol, em formato retangular, com 250 metros de perímetro. Foi elaborada uma planta para esse campo na escala 1 : 2 000. Na planta, a medida do perímetro do campo de futebol, em metro, é:", "0,0005","0,125", "8","250", "8","");
        final ListaDeQuestoes questao3 = new ListaDeQuestoes("(FGV) Sejam os números 7, 8, 3, 5, 9 e 5 seis números de uma lista de nove números inteiros. O maior valor possível para a mediana dos nove números da lista é","5","6","7","8","8","");
        final ListaDeQuestoes questao4 = new ListaDeQuestoes("(Fundatec) Se a mediana de um determinado processo for igual a 7, isso quer dizer que:","O 7º valor da amostra representará a mediana.","O 7º valor da amostra ordenada representará a mediana.","A posição mediana é 7.","50% dos valores da amostra são iguais a 7.","50% dos valores da amostra são iguais a 7.","");
        final ListaDeQuestoes questao5 = new ListaDeQuestoes("(IF-CE 2020) Um relógio A bate a cada 15 minutos, outro relógio B bate a cada 20 minutos, e um terceiro relógio C, a cada 25 minutos. O menor intervalo de tempo decorrido entre duas batidas simultâneas dos três relógios, em horas, é igual a:","3","6","4","5","5","");

        // add todas as questôes para List<ListaDeQuestoes>
        listaDeQuestoes.add(questao1);
        listaDeQuestoes.add(questao2);
        listaDeQuestoes.add(questao3);
        listaDeQuestoes.add(questao4);
        listaDeQuestoes.add(questao5);

        return listaDeQuestoes;
    }
    private static List<ListaDeQuestoes> questoesDeQuimica(){
        final List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();

        // Criar objetos das listas de questões da classe e passar as questôes juntamente com opções e respostas
        final ListaDeQuestoes questao1 = new ListaDeQuestoes("(Unesp 2021) As bacteriorrizas são exemplos de associações simbióticas entre bactérias e raízes de plantas leguminosas. Essas bactérias fixam o nitrogênio atmosférico (N2), transformando-o em amônia (NH3). Nessa transformação, o número de oxidação do elemento nitrogênio é alterado de:","+2 para –3, sendo reduzido.","+2 para +1, sendo reduzido.","0 para +3, sendo oxidado."," 0 para –3, sendo reduzido."," 0 para –3, sendo reduzido.","");
        final ListaDeQuestoes questao2 = new ListaDeQuestoes("As chuvas ácidas podem ter diferentes composições dependendo do local onde são formadas, as mais nocivas são formadas em grandes centros industriais, onde há queima de combustíveis fósseis (gasolina, óleo diesel). Esse tipo de chuva é carregado de poluentes, marque a opção que traz os compostos que a torna nociva à saúde.","óxidos de carbono (CO, CO2)","óxidos de cálcio (CaO, CaO2)","óxidos de enxofre (SO2, SO3)","óxidos de nitrogênio (NO, NO2)","óxidos de enxofre (SO2, SO3)","");
        final ListaDeQuestoes questao3 = new ListaDeQuestoes("Quantos elétrons de valência existem na configuração do elemento químico de número atômico 83?","2","3","4","5","5","");
        final ListaDeQuestoes questao4 = new ListaDeQuestoes("Qual dos números atômicos a seguir corresponde a um elemento químico que apresenta em sua camada de valência 3 elétrons?","55", "32","49","17","49","");
        final ListaDeQuestoes questao5 = new ListaDeQuestoes("(UEFS-BA) O titânio é um metal utilizado na fabricação de motores de avião e pinos para prótese. Quantos elétrons há no último nível da configuração eletrônica desse metal? Dado: Ti (Z =22).","4","3","2","1","2","");

        // add todas as questôes para List<ListaDeQuestoes>
        listaDeQuestoes.add(questao1);
        listaDeQuestoes.add(questao2);
        listaDeQuestoes.add(questao3);
        listaDeQuestoes.add(questao4);
        listaDeQuestoes.add(questao5);

        return listaDeQuestoes;
    }
    private static List<ListaDeQuestoes> questoesDeGeografia(){
        final List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();

        // Criar objetos das listas de questões da classe e passar as questôes juntamente com opções e respostas
        final ListaDeQuestoes questao1 = new ListaDeQuestoes("(Unitau) Suponha um país com uma pirâmide etária de base larga e topo afunilado, assemelhando-se a um triângulo, apresentando sete a oito camadas de crescimento populacional. Sobre esse país, é possível afirmar que:","apresenta uma alta expectativa de vida.","apresenta uma alta taxa de natalidade.","apresenta uma alta taxa de mortalidade infantil.","essa pirâmide é típica de países desenvolvidos.","apresenta uma alta taxa de natalidade.","");
        final ListaDeQuestoes questao2 = new ListaDeQuestoes("Quais são os dois oceanos que banham a América do Sul na porção leste e oeste?","Pacífico e Índico.","Atlântico e Pacífico","Mediterrâneo e Pacífico.","Atlântico e Mediterrâneo.","Atlântico e Pacífico","");
        final ListaDeQuestoes questao3 = new ListaDeQuestoes("(Enem) Considerando a riqueza dos recursos hídricos brasileiros, uma grave crise de água em nosso país poderia ser motivada por:","reduzida área de solos agricultáveis.","ausência de reservas de águas subterrâneas.","escassez de rios e de grandes bacias hidrográficas.","degradação dos mananciais e desperdício no consumo.","degradação dos mananciais e desperdício no consumo.","");
        final ListaDeQuestoes questao4 = new ListaDeQuestoes("A América do Sul é um subcontinente localizado na porção mais austral da América. Ao longo da sua extensão latitudinal, ela é cortada pelas seguintes linhas imaginárias:","Linha do Equador e Trópico de Capricórnio.","Trópico de Câncer e Círculo Polar Ártico.","Meridiano de Greenwich e Trópico de Capricórnio.","Trópico de Capricórnio e Trópico de Câncer.","Linha do Equador e Trópico de Capricórnio.","");
        final ListaDeQuestoes questao5 = new ListaDeQuestoes("O Brasil é o maior país em extensão territorial da América do Sul. Ele faz fronteiras com 10 países da América do Sul, com exceção de","Bolívia e Peru.","Guiana e Chile.","Chile e Equador.","Equador e Guiana.","Chile e Equador.","");

        // add todas as questôes para List<ListaDeQuestoes>
        listaDeQuestoes.add(questao1);
        listaDeQuestoes.add(questao2);
        listaDeQuestoes.add(questao3);
        listaDeQuestoes.add(questao4);
        listaDeQuestoes.add(questao5);

        return listaDeQuestoes;
    }
    private static List<ListaDeQuestoes> questoesTodas(){
        List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();

        listaDeQuestoes.addAll(questoesDeGeografia());
        listaDeQuestoes.addAll(questoesDeQuimica());
        listaDeQuestoes.addAll(questoesDeMatematica());
        listaDeQuestoes.addAll(questoesDePortugues());

        return listaDeQuestoes;
    }
    public static List<ListaDeQuestoes> getQuestoes(String selecionarMaterias){
        switch (selecionarMaterias){
            case "portugues":
                return questoesDePortugues();
            case "matematica":
                return questoesDeMatematica();
            case "quimica":
                return questoesDeQuimica();
            case "geografia":
                return questoesDeGeografia();
            default:
                return questoesTodas();
        }
    }
}
