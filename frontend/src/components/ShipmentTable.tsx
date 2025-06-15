import { useEffect, useState } from 'react';
import Shipment from './Shipment';
import { API } from '../api/Api';
import { IShipment } from '../interfaces/IShipment';

const ShipmentTable = () => {
  const [shipments, setShipments] = useState([]);
  const [errorMessage, setErrorMessage] = useState('');
  const [refresh, setRefresh] = useState(false);
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
    API.getShipments()
      .then((response) => {
        if (response.length === 0) {
          setErrorMessage('No shipments found.');
        }
        setShipments(response);
        console.log('Shipments fetched successfully:', response);
      })
      .catch((error) => {
        console.error('Error fetching shipments:', error);
        setErrorMessage('Failed to fetch shipments. Please try again later.');
      });
    API.getShipments();
  }, [refresh]);

  const handleDeleteShipment = (id: number) => {
    API.deleteShipment(id);
    setRefresh(!refresh);
    console.log(`Shipment with ID ${id} deleted successfully.`);
  };

  return (
    <div className="flex flex-col items-center">
      <div className="flex flex-row gap-8 items-baseline justify-center w-full p-4 mb-4 bg-gray-300">
        <h1 className="text-2xl font-bold mb-4">Shipments</h1>
        <span>
          <button className="bg-blue-500 text-white px-4 py-2 rounded">
            <a href="/create-shipment">Create Shipment</a>
          </button>
        </span>
      </div>

      <div className="flex flex-col items-center w-full max-w-6xl p-4 bg-white shadow-md rounded-lg">
        <div className="flex flex-row gap-2 items-baseline justify-between w-full mb-4">
          {shipmentsTableHeader.map((header, index) => (
            <p key={index} className="font-semibold text-gray-700">
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
            onDelete={() => handleDeleteShipment(shipment.id)}
          />
        ))}
      </div>
      {errorMessage && <p className="text-red-500 mt-10">{errorMessage}</p>}
    </div>
  );
};

export default ShipmentTable;
