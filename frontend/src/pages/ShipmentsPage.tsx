import axios from 'axios';
import Navbar from '../components/Navbar';
import { useState, useEffect } from 'react';
import Shipment from '../components/Shipment';

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
  const shipmentsTableHeader = [
    'unloading place',
    'unloading time',
    'plate number',
    'duration',
    'text',
    'edit',
    'delete',
  ];

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
        <h1 className="text-2xl py-4 font-bold text-gray-900 flex justify-center ">
          List of shipments
        </h1>
        <div className="bg-gray-300 grid grid-cols-7 gap-3 items-center px-10">
          {shipmentsTableHeader.map((item) => (
            <div>{item}</div>
          ))}
        </div>
        <div>
          {shipments.map((oneShipment: IShipment) => {
            return <Shipment key={oneShipment.id} {...oneShipment} />;
          })}
        </div>
        <div className="text-red-600 flex justify-center items-center mt-5">
          {errorMessage && <p> {errorMessage} </p>}
        </div>
      </section>
    </div>
  );
};

export default ShipmentsPage;
