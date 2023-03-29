import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [servers, setServers] = useState([]);
  const [name, setName] = useState('');
  const [id, setId] = useState('');
  const [language, setLanguage] = useState('');
  const [framework, setFramework] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/servers')
      .then(res => {
        setServers(res.data);
      })
      .catch(err => {
        console.error(err);
      });
  }, []);

  const handleCreateServer = () => {
    const data = {
      name: name,
      id: id,
      language: language,
      framework: framework
    };
    axios.post('http://localhost:8080/servers', data)
      .then(res => {
        setServers([...servers, res.data]);
        setName('');
        setId('');
        setLanguage('');
        setFramework('');
      })
      .catch(err => {
        console.error(err);
      });
  };

  const handleDeleteServer = (serverId) => {
    axios.delete(`http://localhost:8080/servers/${serverId}`)
      .then(() => {
        setServers(servers.filter(server => server.id !== serverId));
      })
      .catch(err => {
        console.error(err);
      });
  };

  return (
    <div>
      <h1>Servers</h1>
      <ul>
        {servers.map(server => (
          <li key={server.id}>
            {server.name} ({server.language}, {server.framework}) 
            <button onClick={() => handleDeleteServer(server.id)}>Delete</button>
          </li>
        ))}
      </ul>
      <h2>Create a new server:</h2>
      <form onSubmit={e => { e.preventDefault(); handleCreateServer(); }}>
        <label>
          Name:
          <input type="text" value={name} onChange={e => setName(e.target.value)} />
        </label>
        <br />
        <label>
          ID:
          <input type="text" value={id} onChange={e => setId(e.target.value)} />
        </label>
        <br />
        <label>
          Language:
          <input type="text" value={language} onChange={e => setLanguage(e.target.value)} />
        </label>
        <br />
        <label>
          Framework:
          <input type="text" value={framework} onChange={e => setFramework(e.target.value)} />
        </label>
        <br />
        <button type="submit">Create</button>
      </form>
    </div>
  );
}

export default App;
