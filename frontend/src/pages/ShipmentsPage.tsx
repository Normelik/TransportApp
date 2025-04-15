import axios from 'axios';
import Navbar from '../components/Navbar';
import { useState, useEffect } from 'react';
import Shipment from '../components/ui/Shipment';

interface IShipment {
  id: number;
  unloadingTime: string;
  unloadingPlace: string;
  plateNumber: string;
  isBooked: boolean;
  text: string;
  duration: number;
}

type Props = {
  links: string[];
};

const API_BASE_URL = 'http://localhost:8080/api';

// const API_KEY = ""

const API_OPTIONS = {
  method: 'GET',
  headers: {
    accept: 'application/json',
    // authorization:"Bearer ${API_KEY}"
  },
};

const ShipmentsPage = ({ links }: Props) => {
  const [shipments, setShipments] = useState([]);
  const [errorMessage, setErrorMessage] = useState('');

  useEffect(() => {
    axios
      .get(`${API_BASE_URL}/shipments`, API_OPTIONS)
      .then((response) => {
        setShipments(response.data);
      })
      .catch((error) => {
        console.error('Error fetching shipments: ', error);
        setErrorMessage('Error fetching shipments. Please try it again later.');
      });
  }, []);

  return (
    <div>
      <header>
        <Navbar links={links} />
      </header>
      <section>
        <h1>List of shipments</h1>
        <div>
          {shipments.map((oneShipment: IShipment) => {
            return <Shipment key={oneShipment.id} {...oneShipment} />;
          })}
        </div>
        {errorMessage && <p> {errorMessage} </p>}
      </section>
    </div>
  );
};

export default ShipmentsPage;
