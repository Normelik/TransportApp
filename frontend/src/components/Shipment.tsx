import { RiDeleteBin6Line, RiEdit2Line } from 'react-icons/ri';

interface IShipment {
  id: number;
  unloadingTime: string;
  unloadingPlace: string;
  plateNumber: string;
  text: string;
  duration: number;
}

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
      <p>{unloadingTime}</p>
      <p>{plateNumber}</p>
      <p>{duration}</p>
      <p>{text}</p>
      <button>
        <RiEdit2Line />
      </button>
      <button>
        <RiDeleteBin6Line />
      </button>
    </div>
  );
};

export default Shipment;
