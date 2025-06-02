import { RiDeleteBin6Line, RiEdit2Line } from 'react-icons/ri';
import { IShipment } from '../interfaces/IShipment';

const Shipment = ({
  unloadingTime,
  unloadingPlace,
  plateNumber,
  text,
  duration,
}: IShipment) => {
  return (
    <div className="grid grid-cols-7 gap-3 items-center px-10">
      <p>{unloadingPlace}</p>
      <p>{unloadingPlace}</p>
      <p>{unloadingTime}</p>
      <p>{plateNumber}</p>
      <p>{duration}</p>
      <p>{text}</p>
      <button className="text-blue-500 hover:text-blue-700">
        <RiEdit2Line />
      </button>
      <button className="text-red-500 hover:text-red-700">
        <RiDeleteBin6Line />
      </button>
    </div>
  );
};

export default Shipment;
