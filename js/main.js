
function calcular(){
    const li = $("resultado")
    li.empty();

    let contador, a = 0;
    let exp = parseInt(document.getElementById("potencia").value);
    let epsl = Math.abs(parseInt(document.getElementById("epls").value));
    const valoresDeX = document
        .getElementById("valx")
        .value.split(',')
        .map(Number);

    if (valoresDeX.length !== exp + 1) {
        document.getElementById("resultado").innerHTML =
        "NOJOSADIOANDINAOWIDAWD"
        return;
    }
    
    epsl = Math.pow(10, -epsl);
    const valores = new Array(11);
    const variacoes = new Array(exp + 1);
    const dominioB = new Array(22);
    const dominioA = new Array(22);

    for (contador = 0; contador < valores.length; ++contador) {
        valores[contador] = contador -5;
    }
    
    console.log(valores);
    
    

    /* Calculando "X" das Funções */
    for (let contador = 0; contador < valores.length; contador++){
        let result = 0;
        for (let cont = 0; cont < valoresDeX.length; cont++) {
            result = (Math.pow(valores[contador], cont) * valoresDeX[cont] + result);
        }
        variacoes[contador] = result;
    }

    // Capturando Intervalos
    for (let contador = 1; contador < variacoes.length; contador++) {
        if ((variacoes[contador] > 0 && variacoes[contador - 1] < 0) || (variacoes[contador] < 0 && variacoes[contador - 1] > 0) || (variacoes[contador] == 0 && variacoes[contador - 1] < 0) || (variacoes[contador] < 0 && variacoes[contador - 1] == 0)) {
            if(variacoes[contador]>= 0 && variacoes[contador-1]<= 0){
                dominioA[a] = (valores[contador]);
                dominioB[a] = (valores[contador-1]);
                ++a;
            }else if(variacoes[contador]<= 0 && variacoes[contador-1] >= 0){
                dominioB[a] = (valores[contador]);
                dominioA[a] = (valores[contador-1]);
                ++a;
            }
        }
    }


        
    for(let alet = 0 ; alet < dominioA.length; alet++){
        if(dominioA[alet] == 0.0 && dominioB[alet] == 0.0){
        }else{

            let xa = dominioA[alet];
            let xb = dominioB[alet];
            let valor = 0;
            let media = (xa+xb)/2;
            let comparacao = 1;
            let pp = [];

            while(comparacao > epsl) {
                
                comparacao = Math.abs(xa-xb);
                media = (xa+xb) / 2;
                result = 0;
                    for (let cont = 0; cont < valoresDeX.length; cont++) {
                        result = (Math.pow(media, cont) * valoresDeX[cont] + result);
                    }
                valor = result;
                if(valor > 0){
                    xa = media;
                }else if(valor < 0){
                    xb = media;
                }
                pp.push(media);
            }
            let index = pp.length - 1;

            if(dominioA[alet] != undefined){
                let li = document.createElement("li");
                li.innerHTML = (
                    "<strong>" +
                    "Intevalo: { " + dominioA[alet] + " ; " + dominioB[alet] + " }" + 
                    "</strong>"+
                    "<br>" + 
                    "Raiz: " +
                    pp[index] + 
                    "<br>"+
                    "<br>");
                document.getElementById("resultado").appendChild(li);
            }
        }
    }
}


    