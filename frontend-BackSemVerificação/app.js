async function carregar() {
    const res = await fetch ('http://localhost:8080/transacoes');
    const dados = await res.json();

    const lista = document.getElementById('lista');
    lista.innerHTML = "";

    let saldo = 0;

    dados.forEach(t => {
        const li = document.createElement('li');

        li.innerHTML = `
        ${t.descricao} - ${t.valor} (${t.tipo})
        <button onclick="remover(${t.id})">X</button>`;

        lista.appendChild(li);

        saldo += t.tipo === 'receita' ? t.valor : -t.valor;
    });

    document.getElementById('saldo').innerText = saldo;
}

async function adicionar() {
    const descricao = document.getElementById('descricao').value;
    const valor = Number(document.getElementById('valor').value);
    const tipo = document.getElementById('tipo').value;

    await fetch('http://localhost:3000/transacoes', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({descricao, valor, tipo})
    });

    carregar();
}

async function remover(id) {
    await fetch(`http://localhost:3000/transacoes/${id}`, {
        method: 'DELETE'
    })

    carregar();
}

carregar();