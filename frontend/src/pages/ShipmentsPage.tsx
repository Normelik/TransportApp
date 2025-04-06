import shipments from '../assets/Data';
import Navbar from '../components/Navbar';
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
type Props = {
  links: string[];
};

const ShipmentsPage = ({ links }: Props) => {
  return (
    <div>
      <h1>List of shipments</h1>
      <Navbar links={links} />
      <div>
        {shipments.map((oneShipment: Shipment) => {
          return <Shipment key={oneShipment.id} {...oneShipment} />;
        })}
      </div>
    </div>
  );
};

export default ShipmentsPage;
