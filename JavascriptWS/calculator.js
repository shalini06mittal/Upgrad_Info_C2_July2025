function calculate(){
    //alert('clicked')
    let n1ele = document.getElementById('n1');
    let n2ele = document.getElementById('n2');
    let opele = document.getElementById('op');
    let v1 = parseInt(n1ele.value);
    let v2 = parseInt(n2ele.value);
    const selOp = opele.value;
    console.log(selOp);
    let res = 0;
    switch(selOp){
        case '+':
            res = v1+v2;
            break;
        case '*':
            res = v1*v2;
            break;
        case '-':
            res = v1-v2;
            break;
        case '/':
            res = v1/v2;
            break;
    }
    let pele = document.getElementById('res');
    pele.innerHTML =   "Result: <b>"+ res + "</b>";
}