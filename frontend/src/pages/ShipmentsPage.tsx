import { Button } from '@chakra-ui/react';
import shipments from '../data';
import Shipment from '../components/ui/Shipment';

interface Shipment {
  id: number;
  unloadingTime: string;
  unloadingPlace: string;
  plateNumber: string;
  isBooked: boolean;
  text: string;
  duration: number;
}

const ShipmentsPage = () => {
  return (
    <div>
      <h1>List of shipments</h1>
      <div>
        {shipments.map((oneShipment: Shipment) => {
          return <Shipment key={oneShipment.id} {...oneShipment} />;
        })}
      </div>
    </div>
  );
};

export default ShipmentsPage;
