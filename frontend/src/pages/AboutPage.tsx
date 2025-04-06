import Navbar from '../components/Navbar';

type Props = {
  links: string[];
};

const About = ({ links }: Props) => {
  return (
    <div>
      <Navbar links={links} />
      <h1>About the company</h1>
    </div>
  );
};

export default About;
