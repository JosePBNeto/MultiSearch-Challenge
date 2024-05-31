import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

const App = () => {
    const [searchQuery, setSearchQuery] = useState('');
    const [results, setResults] = useState({});
    const [filteredResults, setFilteredResults] = useState({});
    const [totalResults, setTotalResults] = useState(0);
    const [notFound, setNotFound] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/search?query=');
                const data = response.data;
                setResults(data);
                setFilteredResults(data);
                const total = Object.values(data).reduce((sum, arr) => sum + arr.length, 0);
                setTotalResults(total);
                setNotFound(total === 0);
            } catch (error) {
                console.error('Error fetching data:', error);
                setNotFound(true);
            }
        };
        fetchData();
    }, []);

    const handleSearch = () => {
        if (searchQuery === '') {
            setFilteredResults(results);
            setNotFound(false);
        } else {
            const filtered = {};
            Object.keys(results).forEach(category => {
                filtered[category] = results[category].filter(item => {
                    return Object.values(item).some(value =>
                        value.toString().toLowerCase().includes(searchQuery.toLowerCase())
                    );
                });
            });
            setFilteredResults(filtered);
            const total = Object.values(filtered).reduce((sum, arr) => sum + arr.length, 0);
            setTotalResults(total);
            setNotFound(total === 0);
        }
    };

    return (
        <div className="container">
            <div className="header">
                <img src="/logo.png" alt="MultiSearch Logo" className="logo" />
            </div>
            <div className="search-bar">
                <input
                    type="text"
                    placeholder="Search"
                    value={searchQuery}
                    onChange={e => setSearchQuery(e.target.value)}
                />
                <button onClick={handleSearch}><i className="fa fa-search"></i>GO</button>
            </div>
            <div className="results-count">
                {totalResults > 0 && <p>Foram encontrados {totalResults} resultados:</p>}
            </div>
            <div className="results">
                {notFound && <p>Produto não encontrado</p>}
                {Object.keys(filteredResults).map(category => (
                    <div key={category} className="category">
                        <h3>{getCategoryName(category)} ({filteredResults[category].length} itens encontrados)</h3>
                        <ul>
                            {filteredResults[category].map((item, index) => (
                                <li key={index}>
                                    <a href={`#${item.EquipmentID || item.PurchaseOrderID || item.SalesOrderID || item.WorkforceID} `} className="item-link">
                                        #{item.EquipmentID || item.PurchaseOrderID || item.SalesOrderID || item.WorkforceID} {''}
                                    </a>
                                    {item.EquipmentName || item.MaterialName || item.Name} 
                                    {item.Quantity && ` Qtd: ${item.Quantity}`}
                                    {item.TotalCost && ` Total: ${item.TotalCost}`}
                                    {item.TotalValue && ` Total: ${item.TotalValue}`}
                                </li>
                            ))}
                        </ul>
                    </div>
                ))}
            </div>
        </div>
    );
};

const getCategoryName = (category) => {
    switch (category) {
        case 'equipments':
            return 'Equipamentos';
        case 'purchaseOrders':
            return 'Pedidos de Compra';
        case 'salesOrders':
            return 'Pedidos de Venda';
        case 'workforce':
            return 'Mão de obra';
        default:
            return category;
    }
};

export default App;
