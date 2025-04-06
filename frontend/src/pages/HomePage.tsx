import Navbar from '../components/Navbar';

type Props = {
  links: string[];
};

const HomePage = ({ links }: Props) => {
  return (
    <div>
      <Navbar links={links} />
    </div>
  );
};

export default HomePage;
