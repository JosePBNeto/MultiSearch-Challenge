import React, { useState, useEffect } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [data, setData] = useState({});
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState({});

  useEffect(() => {
    fetch('/data/data.json')
      .then(response => response.json())
      .then(data => {
        console.log(data); // Verificar se os dados são carregados corretamente
        setData(data);
        setSearchResults(data); // Inicializa a tela com todos os dados
      })
      .catch(error => console.error('Error loading data:', error));
  }, []);

  const handleSearch = () => {
    const filteredResults = {
      pedidosVenda: filteredData(data.pedidosVenda, searchTerm),
      pedidosCompra: filteredData(data.pedidosCompra, searchTerm),
      produtos: filteredData(data.produtos, searchTerm),
      equipamentos: filteredData(data.equipamentos, searchTerm),
      maoObra: filteredData(data.maoObra, searchTerm)
    };
    setSearchResults(filteredResults);
  };

  const filteredData = (dataArray, term) => {
    if (!dataArray) return [];
    return dataArray.filter(item => item.descricao.toLowerCase().includes(term.toLowerCase()));
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col">
          <img src="logo.png" alt="MultiSearch Logo" className="logo" />
          <div className="input-group my-3">
            <input
              type="text"
              className="form-control"
              placeholder="Mesa Ret"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
            />
            <div className="input-group-append">
              <button className="btn btn-primary" onClick={handleSearch}>Buscar</button>
            </div>
          </div>
          <div>
            <h3>Pedidos de Venda</h3>
            <ul>
              {searchResults.pedidosVenda && searchResults.pedidosVenda.length > 0 ? (
                searchResults.pedidosVenda.map(item => (
                  <li key={item.id}>{item.descricao} - Qtd: {item.quantidade}</li>
                ))
              ) : (
                <li>Produto não encontrado</li>
              )}
            </ul>
          </div>
          <div>
            <h3>Pedidos de Compra</h3>
            <ul>
              {searchResults.pedidosCompra && searchResults.pedidosCompra.length > 0 ? (
                searchResults.pedidosCompra.map(item => (
                  <li key={item.id}>{item.descricao} - Qtd: {item.quantidade}</li>
                ))
              ) : (
                <li>Produto não encontrado</li>
              )}
            </ul>
          </div>
          <div>
            <h3>Produtos</h3>
            <ul>
              {searchResults.produtos && searchResults.produtos.length > 0 ? (
                searchResults.produtos.map(item => (
                  <li key={item.id}>{item.descricao}</li>
                ))
              ) : (
                <li>Produto não encontrado</li>
              )}
            </ul>
          </div>
          <div>
            <h3>Equipamentos</h3>
            <ul>
              {searchResults.equipamentos && searchResults.equipamentos.length > 0 ? (
                searchResults.equipamentos.map(item => (
                  <li key={item.id}>{item.descricao}</li>
                ))
              ) : (
                <li>Produto não encontrado</li>
              )}
            </ul>
          </div>
          <div>
            <h3>Mão de Obra</h3>
            <ul>
              {searchResults.maoObra && searchResults.maoObra.length > 0 ? (
                searchResults.maoObra.map(item => (
                  <li key={item.id}>{item.descricao}</li>
                ))
              ) : (
                <li>Produto não encontrado</li>
              )}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
