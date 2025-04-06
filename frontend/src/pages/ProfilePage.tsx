import Navbar from '../components/Navbar';

type Props = {
  links: string[];
};

const Profile = ({ links }: Props) => {
  return (
    <div>
      <Navbar links={links} />
      <h1>Profile</h1>
    </div>
  );
};

export default Profile;
