interface IShipment {
  id: number;
  unloadingTime: string;
  unloadingPlace: string;
  plateNumber: string;
  isBooked: boolean;
  text: string;
  duration: number;
}

const Shipment = ({
  unloadingTime,
  unloadingPlace,
  isBooked,
  text,
  duration,
}: IShipment) => {
  return (
    <div className="one-shipment">
      <p>{unloadingPlace}</p>
      <p>{unloadingTime}</p>
      <p>{text}</p>
      <p>{duration}</p>
      <p>{isBooked}</p>
      <div>
        <button>Edit</button>
        <button>delete</button>
      </div>
    </div>
  );
};

export default Shipment;
