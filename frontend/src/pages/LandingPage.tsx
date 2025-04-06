import Navbar from '../components/Navbar';

type Props = {
  links: string[];
};

const LandingPage = ({ links }: Props) => {
  return (
    <div>
      <Navbar links={links} />
      <h1>Welcome to Transport App</h1>
    </div>
  );
};

export default LandingPage;
