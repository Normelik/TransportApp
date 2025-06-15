import Navbar from '../components/Navbar';
import ShipmentTable from '../components/ShipmentTable';

type Props = {
  links: string[];
};

const ShipmentsPage = ({ links }: Props) => {
  return (
    <div>
      <header>
        <Navbar links={links} />
      </header>
      <section>
        <ShipmentTable />
      </section>
    </div>
  );
};

export default ShipmentsPage;
