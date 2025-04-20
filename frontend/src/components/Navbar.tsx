import { Link } from 'react-router-dom';

type Props = {
  links: string[];
};

const Navbar = ({ links }: Props) => {
  return (
    <nav className="bg-green-600 py-4 px-3 text-white flex justify-between items-center shadow-black">
      <Link
        to="/"
        className="text-2xl size-8 font-bold decoration-0 text-white"
      >
        TransportApp
      </Link>
      <div className="flex gap-3">
        {links.map((item: string) => {
          const path = `/${item.toLowerCase()}`;
          return (
            <Link
              key={path}
              to={path}
              className="transform transition hover:-translate-y-1 motion-reduce:transition-none motion-reduce:hover:transform-none"
            >
              {item}
            </Link>
          );
        })}
      </div>
    </nav>
  );
};

export default Navbar;
