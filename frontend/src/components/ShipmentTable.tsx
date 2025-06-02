import { useEffect, useState } from 'react';
import Shipment from './Shipment';
import { API } from '../api/Api';
import { IShipment } from '../interfaces/IShipment';

const ShipmentTable = () => {
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
    setErrorMessage(''); // Reset error message before fetching
    setShipments([]); // Reset shipments before fetching
    API.getShipments()
      .then((response) => {
        if (response.length === 0) {
          setErrorMessage('No shipments found.');
        }
        setShipments(response);
      })
      .catch((error) => {
        console.error('Error fetching shipments:', error);
        setErrorMessage('Failed to fetch shipments. Please try again later.');
      });
  }, []);
  return (
    <div className="flex flex-col items-center">
      <h1 className="text-2xl font-bold mb-4">Shipments</h1>
      <div className="grid grid-cols-7 gap-3 items-center px-10">
        {shipmentsTableHeader.map((header, index) => (
          <p key={index} className="font-bold">
            {header}
          </p>
        ))}
      </div>
      {shipments.map((shipment: IShipment) => (
        <Shipment
          key={shipment.id}
          id={shipment.id}
          unloadingTime={shipment.unloadingTime}
          unloadingPlace={shipment.unloadingPlace}
          plateNumber={shipment.plateNumber}
          text={shipment.text}
          duration={shipment.duration}
          isBooked={shipment.isBooked}
        />
      ))}

      {errorMessage && <p className="text-red-500 mt-10">{errorMessage}</p>}
    </div>
  );
};

export default ShipmentTable;
