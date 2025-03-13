import { Button } from '@chakra-ui/react';

const Shipment = ({
  unloadingTime,
  unloadingPlace,
  isBooked,
  text,
  duration,
}) => {
  return (
    <div className="one-shipment">
      <p>{unloadingPlace}</p>
      <p>{unloadingTime}</p>
      <p>{text}</p>
      <p>{duration}</p>
      <div>
        <Button>Edit</Button>
        <Button>delete</Button>
      </div>
    </div>
  );
};

export default Shipment;
