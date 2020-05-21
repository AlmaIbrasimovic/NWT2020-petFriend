import React from 'react';
import './App.css';
import {Zivotinje, KreirajZivotinju} from './Zivotinje/index'
import {KreirajVakcinu} from './Vakcine/index'
import { BrowserRouter as Router, Route, Switch } from "react-router-dom"
import { KnowledgeNavbar } from "./Navigation/index"

function App() {
  return (
    <Router>
      <div className="App">
        <KnowledgeNavbar />
        <Route path="/zivotinje" component={Zivotinje} />
        <Route path="/kreiraj-zivotinju" component={KreirajZivotinju} />
        <Route path="/kreiraj-vakcinu" component={KreirajVakcinu} />
      </div>
    </Router>
  );
}

export default App;
